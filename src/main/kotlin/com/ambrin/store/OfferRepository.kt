package com.ambrin.store

interface OfferRepository {
    fun getOffer(item: String): Offer
}