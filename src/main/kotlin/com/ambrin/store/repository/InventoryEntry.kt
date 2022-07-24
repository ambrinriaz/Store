package com.ambrin.store.repository

import java.math.BigDecimal

data class InventoryEntry(
    val name: String,
    val price: BigDecimal,
    var count: Int
)