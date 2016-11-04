package com.example.learningkotlin.data.models

/**
 * Created by mateus on 04/11/16.
 */
class Contact(
        var name: String = "",
        var age: Int = 0,
        var pictureUrl: String = "",
        var sex: Sex = Contact.Sex.MALE) {

    enum class Sex {
        MALE, FEMALE
    }
}