package com.example.learningkotlin.business

import org.greenrobot.eventbus.EventBus

/**
 * Created by mateus on 24/12/16.
 */

class EventSender {

    fun send(event: Any) {
        EventBus.getDefault().post(event)
    }
}