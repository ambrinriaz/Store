package com.ambrin.store.order


interface Subscriber {

    fun notify(event: Event)
}