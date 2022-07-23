package com.ambrin.store.offers

import com.ambrin.store.Offer
import java.math.BigDecimal

class BogoOffer : Offer {

    override fun calculateDiscount(count: Int, price: BigDecimal): BigDecimal {
        val multiplier = BigDecimal(count / 2)
        return price.multiply(multiplier)
    }
}