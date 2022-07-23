package com.ambrin.store

import java.math.BigDecimal

interface ItemRepository {

    fun getPrice(item: String): BigDecimal
}