package com.ambrin.store

import com.ambrin.store.order.OrderService
import com.ambrin.store.repository.InMemoryItemRepository
import com.ambrin.store.repository.InMemoryOfferRepository


fun main(args: Array<String>) {
    val items = args.toList()

    val orderService = OrderService(
        InMemoryItemRepository(1, 1),
        InMemoryOfferRepository()
    )

    orderService.addSubscriber(MailSubscriber())
    orderService.processOrder(items)
}