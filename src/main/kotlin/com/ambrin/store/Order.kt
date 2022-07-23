package com.ambrin.store

import java.math.BigDecimal

class Order(private val itemRepository: ItemRepository, private val items: List<String>) {

    fun calculatePrice(): BigDecimal {
       return items.stream()
            .map { item -> itemRepository.getPrice(item) }
            .reduce(BigDecimal.ZERO, BigDecimal::add)
    }

}
