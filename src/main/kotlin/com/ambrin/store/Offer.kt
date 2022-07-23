package com.ambrin.store

import java.math.BigDecimal

interface Offer {

    fun calculateDiscount(count: Int, price: BigDecimal): BigDecimal
}