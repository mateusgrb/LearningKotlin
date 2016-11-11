package com.example.learningkotlin.data.models

import io.realm.RealmObject

/**
 * Created by mateus on 04/11/16.
 */
open class ContactRealm(
        override var name: String = "",
        override var age: Int = 0,
        override var pictureUrl: String = "",
        override var sex: String = "") : RealmObject(), Contact