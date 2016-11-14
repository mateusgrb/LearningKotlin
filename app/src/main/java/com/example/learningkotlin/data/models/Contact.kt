package com.example.learningkotlin.data.models

import java.io.Serializable

/**
 * Created by mateus on 04/11/16.
 */
interface Contact : Serializable {

    var id: Long
    var name: String
    var age: Int
    var pictureUrl: String
    var sex: String

    enum class Sex {
        MALE, FEMALE
    }
}