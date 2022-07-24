package com.ambrin.store.order

interface OfferRepository {

    fun getOffer(item: String): Offer
}