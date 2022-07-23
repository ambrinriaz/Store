package com.ambrin.store

import java.math.BigDecimal

class InMemoryItemRepository : ItemRepository {
    private val itemMap = mapOf(
        APPLE_ITEM to BigDecimal(APPLE_PRICE),
        ORANGE_ITEM to BigDecimal(ORANGE_PRICE)
    )

    override fun getPrice(item: String): BigDecimal {
        return itemMap[item] ?: BigDecimal.ZERO
    }

    companion object {
        const val APPLE_ITEM = "Apple"
        const val APPLE_PRICE = "0.60"

        const val ORANGE_ITEM = "Orange"
        const val ORANGE_PRICE = "0.25"
    }
}