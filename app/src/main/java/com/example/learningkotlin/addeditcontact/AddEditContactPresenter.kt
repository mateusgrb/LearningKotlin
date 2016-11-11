package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.utils.Validator

/**
 * Created by mateus on 09/11/16.
 */

class AddEditContactPresenter(private var view: AddEditContactContract.View?) :
        AddEditContactContract.Presenter {

    val repository: ContactsRepository = ContactsRepository()

    override fun getSexValues(): List<String> {
        return Contact.Sex.values().map { it.toString() }
    }

    override fun saveContact(name: String, age: String, sex: String) {
        if (!Validator.validateContactName(name)) {
            view?.showContactNameError()
        } else if (!Validator.validateContactAge(age)) {
            view?.showContactAgeError()
        } else if (!Validator.validateContactSex(sex)) {
            view?.showContactSexError()
        } else {
            repository.insertContact(name, age.toInt(), sex)
            view?.onContactSaved()
        }
    }

    override fun onDestroy() {
        view = null
    }
}