package com.example.learningkotlin.data.models

import io.realm.RealmObject

/**
 * Created by mateus on 04/11/16.
 */
interface Contact {

    var name: String
    var age: Int
    var pictureUrl: String
    var sex: String

    enum class Sex {
        MALE, FEMALE
    }
}