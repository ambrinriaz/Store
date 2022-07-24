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
        return Order(itemRepository, offerRepository, items).calculatePrice()
    }

    fun addSubscriber(subscriber: Subscriber) {
        subscriberList.add(subscriber)
    }

    fun processOrder(items: List<String>) {
        val price = calculatePrice(items)

        val event = Event(
            Status.COMPLETED,
            LocalDate.now().plusDays(DEFAULT_DELIVERY_TIME_IN_DAYS),
            price
        )

        subscriberList.forEach { subscriber -> subscriber.notify(event) }
    }
}