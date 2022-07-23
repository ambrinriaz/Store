package com.ambrin.store

import java.math.BigDecimal
import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.APPLE_PRICE
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_PRICE

class InMemoryItemRepository : ItemRepository {
    private val itemMap = mapOf(
        APPLE_ITEM to BigDecimal(APPLE_PRICE),
        ORANGE_ITEM to BigDecimal(ORANGE_PRICE)
    )

    override fun getPrice(item: String): BigDecimal {
        return itemMap[item] ?: BigDecimal.ZERO
    }
}