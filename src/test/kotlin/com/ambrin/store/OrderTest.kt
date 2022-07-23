package com.ambrin.store

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.APPLE_PRICE
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_PRICE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OrderTest {
    private lateinit var orderService: OrderService
    
    @BeforeEach
    fun setUp() {
        orderService = OrderService(InMemoryItemRepository(), InMemoryOfferRepository())
    }

    @Test
    fun should_returnZero_when_calculatingPriceForNoItems() {
        val items = emptyList<String>()
        val price = orderService.calculatePrice(items)
        assertEquals(BigDecimal.ZERO, price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForAnApple() {
        val items = listOf(APPLE_ITEM)
        val price = orderService.calculatePrice(items)
        assertEquals(BigDecimal(APPLE_PRICE), price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForAnOrange() {
        val items = listOf(ORANGE_ITEM)
        val price = orderService.calculatePrice(items)
        assertEquals(BigDecimal(ORANGE_PRICE), price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForMultipleOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)

        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal(items.size))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForMixedItems() {
        val items = listOf(APPLE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)

        val expectedPrice = BigDecimal(APPLE_PRICE).add(BigDecimal(ORANGE_PRICE))
        assertEquals(expectedPrice, price)
    }

}