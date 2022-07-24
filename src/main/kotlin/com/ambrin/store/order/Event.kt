package com.ambrin.store.order

import java.math.BigDecimal
import java.time.LocalDate

data class Event(val status: Status, val deliveryDate: LocalDate, val price: BigDecimal) {}