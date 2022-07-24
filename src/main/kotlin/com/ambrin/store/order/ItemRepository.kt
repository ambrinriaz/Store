package com.ambrin.store.order

import java.math.BigDecimal

interface ItemRepository {

    fun getPrice(item: String): BigDecimal

    fun decrementInventory(item: String, count: Int)
}