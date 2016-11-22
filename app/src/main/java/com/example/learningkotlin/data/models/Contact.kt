package com.example.learningkotlin.data.models

import java.io.Serializable

/**
 * Created by mateus on 04/11/16.
 */
interface Contact : Serializable {

    var id: Long
    var name: String
    var email: String
    var phone: String
    var pictureUrl: String
}