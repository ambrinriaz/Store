package com.ambrin.store.order

import com.ambrin.store.ItemConstants.DEFAULT_DELIVERY_TIME_IN_DAYS
import java.math.BigDecimal
import java.time.LocalDate

class OrderService(
    private val itemRepository: ItemRepository,
    private val offerRepository: OfferRepository
) {

    private val subscriberList = mutableListOf<Subscriber>()

    fun calculatePrice(items: List<String>): BigDecimal {
        return Order(itemRepository, offerRepository, items).total
    }

    fun addSubscriber(subscriber: Subscriber) {
        subscriberList.add(subscriber)
    }

    fun processOrder(items: List<String>) {
        val order = Order(itemRepository, offerRepository, items)

        val event = try {
            order.processOrder()

            Event(
                status = Status.COMPLETED,
                deliveryDate = LocalDate.now().plusDays(DEFAULT_DELIVERY_TIME_IN_DAYS),
                price = order.total
            )
        } catch (ex: IllegalStateException) {
            Event(
                status = Status.FAILED,
                message = ex.message
            )
        }

        subscriberList.forEach { subscriber -> subscriber.notify(event) }
    }
}