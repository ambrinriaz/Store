package com.ambrin.store

import com.ambrin.store.order.Event
import com.ambrin.store.order.Subscriber

class TestSubscriber : Subscriber {
    var event: Event? = null

    override fun notify(event: Event) {
        this.event = event
    }
}