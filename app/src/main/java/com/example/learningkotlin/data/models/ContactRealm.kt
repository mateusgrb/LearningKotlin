package com.example.learningkotlin.data.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by mateus on 04/11/16.
 */
open class ContactRealm(
        @PrimaryKey
        override var id: Long = 0,
        override var name: String = "",
        override var age: Int = 0,
        override var pictureUrl: String = "",
        override var sex: String = "") : RealmObject(), Contact {

    companion object {
        val ID = "id"
    }
}