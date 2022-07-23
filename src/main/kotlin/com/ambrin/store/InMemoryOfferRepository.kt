package com.ambrin.store

import com.ambrin.store.offers.BogoOffer
import com.ambrin.store.offers.EmptyOffer

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.offers.ThreeForTwoOffer

class InMemoryOfferRepository : OfferRepository {
    private val offerMap = mapOf(
        APPLE_ITEM to BogoOffer(),
        ORANGE_ITEM to ThreeForTwoOffer()
    )

    override fun getOffer(item: String): Offer {
        return offerMap[item] ?: EmptyOffer()
    }

}