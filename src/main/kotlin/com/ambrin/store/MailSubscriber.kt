package com.ambrin.store

import com.ambrin.store.order.Event
import com.ambrin.store.order.Status
import com.ambrin.store.order.Subscriber

class MailSubscriber : Subscriber {

    override fun notify(event: Event) {
        println("Order status is : ${event.status}")

        if (event.status == Status.FAILED) {
            println("Reason: ${event.message}")
        } else {
            println("Estimated delivery time is : ${event.deliveryDate}")
            println("Total order price is : $${event.price}")
        }
    }
}