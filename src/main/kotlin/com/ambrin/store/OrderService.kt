package com.ambrin.store

import java.math.BigDecimal

class OrderService(
    private val itemRepository: ItemRepository,
    private val offerRepository: OfferRepository
) {

    fun calculatePrice(items: List<String>): BigDecimal {
        return Order(itemRepository, offerRepository, items).calculatePrice()
    }
}