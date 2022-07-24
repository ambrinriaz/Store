package com.ambrin.store.repository

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.APPLE_PRICE
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_PRICE
import com.ambrin.store.order.ItemRepository
import java.math.BigDecimal

class InMemoryItemRepository : ItemRepository {

    private val itemMap = mapOf(
        APPLE_ITEM to BigDecimal(APPLE_PRICE),
        ORANGE_ITEM to BigDecimal(ORANGE_PRICE)
    )

    override fun getPrice(item: String): BigDecimal {
        return itemMap[item] ?: BigDecimal.ZERO
    }
}