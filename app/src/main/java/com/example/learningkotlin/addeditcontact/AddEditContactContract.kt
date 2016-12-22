package com.example.learningkotlin.addeditcontact

import android.net.Uri
import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView
import com.example.learningkotlin.data.models.Contact

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
        fun saveContact(contact: Contact, imageUri: Uri?)
        fun onImageSelected()
    }
}