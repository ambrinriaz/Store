package com.ambrin.store

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.DEFAULT_DELIVERY_TIME_IN_DAYS
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.order.OrderService
import com.ambrin.store.order.Status
import com.ambrin.store.repository.InMemoryItemRepository
import com.ambrin.store.repository.InMemoryOfferRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class NotificationTest {
    private lateinit var orderService: OrderService

    @BeforeEach
    fun setUp() {
        orderService =
            OrderService(
                InMemoryItemRepository(),
                InMemoryOfferRepository()
            )
    }

    @Test
    fun should_returnCompletedStatus_when_orderIsProcessed() {
        val items = listOf(APPLE_ITEM, ORANGE_ITEM, ORANGE_ITEM)

        val subscriber = TestSubscriber()
        orderService.addSubscriber(subscriber)
        orderService.processOrder(items)

        assertEquals(Status.COMPLETED, subscriber.event?.status)
    }

    @Test
    fun should_returnEstimatedDeliveryTime_when_orderIsProcessed() {
        val items = listOf(APPLE_ITEM, ORANGE_ITEM, ORANGE_ITEM)

        val subscriber = TestSubscriber()
        orderService.addSubscriber(subscriber)
        orderService.processOrder(items)

        val expectedDate = LocalDate.now().plusDays(DEFAULT_DELIVERY_TIME_IN_DAYS)
        assertEquals(expectedDate, subscriber.event?.deliveryDate)
    }

    @Test
    fun should_returnPrice_when_orderStatusIsCompleted() {
        val items = listOf(APPLE_ITEM, ORANGE_ITEM, ORANGE_ITEM)

        val subscriber = TestSubscriber()
        orderService.addSubscriber(subscriber)
        orderService.processOrder(items)

        val expectedPrice = orderService.calculatePrice(items)
        assertEquals(expectedPrice, subscriber.event?.price)
    }
}

