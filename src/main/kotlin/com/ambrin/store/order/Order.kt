package com.ambrin.store.order

import java.math.BigDecimal

class Order(
    private val itemRepository: ItemRepository,
    private val offerRepository: OfferRepository,
    private val items: List<String>
) {

    private var itemCountMap = mutableMapOf<String, Int>()
    val total = calculatePrice()


    fun processOrder() {
        for ((item, count) in getItemCountMap().entries) {
            itemRepository.decrementInventory(item, count)
        }
    }

    private fun calculatePrice(): BigDecimal {
        var subTotal = BigDecimal.ZERO

        for (item in items) {
            subTotal = subTotal.add(itemRepository.getPrice(item))
        }

        var total = subTotal

        for ((item, count) in getItemCountMap().entries) {
            val offer = offerRepository.getOffer(item)
            val discount = offer.calculateDiscount(count, itemRepository.getPrice(item))
            total = total.subtract(discount)
        }
        return total
    }

    private fun getItemCountMap(): Map<String, Int> {
        if (itemCountMap.isEmpty()) {
            for (item in items) {
                itemCountMap[item] = (itemCountMap[item] ?: 0) + 1
            }
        }
        return itemCountMap
    }

}
