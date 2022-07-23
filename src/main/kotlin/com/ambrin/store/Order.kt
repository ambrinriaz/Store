package com.ambrin.store

import java.math.BigDecimal

class Order(
    private val itemRepository: ItemRepository,
    private val offerRepository: OfferRepository,
    private val items: List<String>
) {

    fun calculatePrice(): BigDecimal {
        val itemCountMap = mutableMapOf<String, Int>()
        var subTotal = BigDecimal.ZERO

        for (item in items) {
            subTotal = subTotal.add(itemRepository.getPrice(item))
            itemCountMap[item] = (itemCountMap[item] ?: 0) + 1
        }

        var total = subTotal

        for ((item, count) in itemCountMap.entries) {
            val offer = offerRepository.getOffer(item)
            val discount = offer.calculateDiscount(count, itemRepository.getPrice(item))
            total = total.subtract(discount)
        }
        return total
    }

}
