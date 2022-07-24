package com.ambrin.store.offers

import com.ambrin.store.order.Offer
import java.math.BigDecimal

class EmptyOffer : Offer {

    override fun calculateDiscount(count: Int, price: BigDecimal): BigDecimal {
        return BigDecimal.ZERO
    }
}