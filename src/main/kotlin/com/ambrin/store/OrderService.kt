package com.ambrin.store

import java.math.BigDecimal

class OrderService(private val itemRepository: ItemRepository) {

    fun calculatePrice(items: List<String>): BigDecimal {
        return Order(itemRepository, items).calculatePrice()
    }
}