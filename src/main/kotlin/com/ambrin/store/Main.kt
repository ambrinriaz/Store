package com.ambrin.store


fun main(args: Array<String>) {
    val items = args.toList()
    val price = OrderService(InMemoryItemRepository()).calculatePrice(items)
    println("Cost is: $$price")
}