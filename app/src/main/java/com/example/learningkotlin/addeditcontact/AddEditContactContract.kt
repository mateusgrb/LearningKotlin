package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView

/**
 * Created by mateus on 09/11/16.
 */

interface AddEditContactContract {

    interface View : BaseView<Presenter> {
        fun showContactNameError()
        fun showContactAgeError()
        fun showContactSexError()
    }

    interface Presenter : BasePresenter {
        fun getSexValues(): List<String>
        fun saveContact(name: String, age: String, sex: String)
    }
}