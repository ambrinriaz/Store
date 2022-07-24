package com.ambrin.store.repository

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.APPLE_PRICE
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_PRICE
import com.ambrin.store.order.ItemRepository
import java.math.BigDecimal

class InMemoryItemRepository(appleCount: Int = 10, orangeCount: Int = 10) : ItemRepository {

    private val itemMap = mapOf(
        APPLE_ITEM to InventoryEntry(APPLE_ITEM, BigDecimal(APPLE_PRICE), appleCount),
        ORANGE_ITEM to InventoryEntry(ORANGE_ITEM, BigDecimal(ORANGE_PRICE), orangeCount)
    )

    override fun getPrice(item: String): BigDecimal {
        return itemMap[item]?.price ?: BigDecimal.ZERO
    }

    override fun decrementInventory(item: String, count: Int) {
        if (itemMap.containsKey(item)) {
            val entry = itemMap.getValue(item)
            val newCount = entry.count - count

            if (newCount < 0) {
                throw IllegalStateException("${entry.name} is out of stock")
            }
            entry.count = newCount
        }
    }
}