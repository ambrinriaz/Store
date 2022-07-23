package com.ambrin.store.offers

import com.ambrin.store.Offer
import java.math.BigDecimal

class ThreeForTwoOffer: Offer {

    override fun calculateDiscount(count: Int, price: BigDecimal): BigDecimal {
        val multiplier = BigDecimal(count / 3)
        return price.multiply(multiplier)
    }
}