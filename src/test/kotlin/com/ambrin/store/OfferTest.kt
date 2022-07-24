package com.ambrin.store

import com.ambrin.store.ItemConstants.APPLE_ITEM
import com.ambrin.store.ItemConstants.APPLE_PRICE
import com.ambrin.store.ItemConstants.ORANGE_ITEM
import com.ambrin.store.ItemConstants.ORANGE_PRICE
import com.ambrin.store.order.OrderService
import com.ambrin.store.repository.InMemoryItemRepository
import com.ambrin.store.repository.InMemoryOfferRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OfferTest {
    private lateinit var orderService: OrderService

    @BeforeEach
    fun setUp() {
        orderService =
            OrderService(
                InMemoryItemRepository(),
                InMemoryOfferRepository()
            )
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForTwoApples() {
        val items = listOf(APPLE_ITEM, APPLE_ITEM)
        val price = orderService.calculatePrice(items)
        assertEquals(BigDecimal(APPLE_PRICE), price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForThreeApples() {
        val items = listOf(APPLE_ITEM, APPLE_ITEM, APPLE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(APPLE_PRICE).multiply(BigDecimal("2"))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForFourApples() {
        val items = listOf(APPLE_ITEM, APPLE_ITEM, APPLE_ITEM, APPLE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(APPLE_PRICE).multiply(BigDecimal("2"))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForThreeOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal("2"))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForFourOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal("3"))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForFiveOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal("4"))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnDiscountedPrice_when_calculatingOfferForSixOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM, ORANGE_ITEM)
        val price = orderService.calculatePrice(items)
        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal("4"))
        assertEquals(expectedPrice, price)
    }
}