package com.example.learningkotlin.business

import org.greenrobot.eventbus.EventBus

/**
 * Created by mateus on 24/12/16.
 */

class EventHandler {

    fun send(event: Any) {
        EventBus.getDefault().post(event)
    }

    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    fun unregister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }
}