package com.ambrin.store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

import com.ambrin.store.InMemoryItemRepository.Companion.APPLE_ITEM
import com.ambrin.store.InMemoryItemRepository.Companion.APPLE_PRICE
import com.ambrin.store.InMemoryItemRepository.Companion.ORANGE_ITEM
import com.ambrin.store.InMemoryItemRepository.Companion.ORANGE_PRICE

class OrderTest {

    @Test
    fun should_returnZero_when_calculatingPriceForNoItems() {
        val items = emptyList<String>()
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)
        assertEquals(BigDecimal.ZERO, price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForAnApple() {
        val items = listOf(APPLE_ITEM)
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)
        assertEquals(BigDecimal(APPLE_PRICE), price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForMultipleApples() {
        val items = listOf(APPLE_ITEM, APPLE_ITEM)
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)

        val expectedPrice = BigDecimal(APPLE_PRICE).multiply(BigDecimal(items.size))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForAnOrange() {
        val items = listOf(ORANGE_ITEM)
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)
        assertEquals(BigDecimal(ORANGE_PRICE), price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForMultipleOranges() {
        val items = listOf(ORANGE_ITEM, ORANGE_ITEM)
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)

        val expectedPrice = BigDecimal(ORANGE_PRICE).multiply(BigDecimal(items.size))
        assertEquals(expectedPrice, price)
    }

    @Test
    fun should_returnPrice_when_calculatingPriceForMixedItems() {
        val items = listOf(APPLE_ITEM, APPLE_ITEM, ORANGE_ITEM, APPLE_ITEM)
        val price = OrderService(InMemoryItemRepository()).calculatePrice(items)

        val totalApplePrice = BigDecimal(APPLE_PRICE).multiply(BigDecimal("3"))
        val totalOrangePrice = BigDecimal(ORANGE_PRICE)
        val expectedPrice = totalApplePrice.add(totalOrangePrice)

        assertEquals(expectedPrice, price)
    }

}