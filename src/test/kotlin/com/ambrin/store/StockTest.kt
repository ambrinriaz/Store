package com.ambrin.store

import com.ambrin.store.order.OrderService
import com.ambrin.store.order.Status
import com.ambrin.store.repository.InMemoryItemRepository
import com.ambrin.store.repository.InMemoryOfferRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StockTest {

    private lateinit var orderService: OrderService

    @BeforeEach
    fun setUp() {
        orderService = OrderService(
            InMemoryItemRepository(appleCount = 1, orangeCount = 1),
            InMemoryOfferRepository()
        )
    }

    @Test
    fun should_returnOrderFailedStatus_when_orderCannotBeProcessed() {
        val items = listOf(ItemConstants.APPLE_ITEM, ItemConstants.ORANGE_ITEM, ItemConstants.ORANGE_ITEM)

        val subscriber = TestSubscriber()
        orderService.addSubscriber(subscriber)
        orderService.processOrder(items)

        Assertions.assertEquals(Status.FAILED, subscriber.event?.status)
    }
}