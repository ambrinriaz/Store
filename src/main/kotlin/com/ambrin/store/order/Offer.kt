package com.ambrin.store.order

import java.math.BigDecimal

interface Offer {

    fun calculateDiscount(count: Int, price: BigDecimal): BigDecimal
}