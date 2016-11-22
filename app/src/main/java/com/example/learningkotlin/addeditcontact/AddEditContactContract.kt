package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView

/**
 * Created by mateus on 09/11/16.
 */

interface AddEditContactContract {

    interface View : BaseView<Presenter> {
        fun showContactNameError()
        fun showContactEmailError()
        fun showContactPhoneError()
        fun onContactSaved()
    }

    interface Presenter : BasePresenter {
        fun saveContact(name: String, email: String, phone: String)
    }
}