package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.data.models.Contact

/**
 * Created by mateus on 09/11/16.
 */

class AddEditContactPresenter(var activity: AddEditContactActivity?) : AddEditContactContract
.Presenter {

    override fun getSexValues(): List<String> {
        return Contact.Sex.values().map { it.toString() }
    }

    override fun saveContact() {

    }

    override fun onDestroy() {
        activity = null
    }
}