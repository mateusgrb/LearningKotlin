package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.events.RefreshListEvent
import com.example.learningkotlin.utils.Validator
import org.greenrobot.eventbus.EventBus

/**
 * Created by mateus on 09/11/16.
 */

class AddEditContactPresenter(private var view: AddEditContactContract.View?) :
        AddEditContactContract.Presenter {

    val repository: ContactsRepository = ContactsRepository()
    var contactId: Long? = null

    override fun saveContact(name: String, email: String, phone: String) {
        if (!Validator.validateContactName(name)) {
            view?.showContactNameError()
        } else if (!Validator.validateContactEmail(email)) {
            view?.showContactEmailError()
        } else if (!Validator.validateContactPhone(phone)) {
            view?.showContactPhoneError()
        } else {
            val contactId = this.contactId
            if (contactId != null) {
                repository.updateContact(contactId, name, email, phone)
            } else {
                repository.insertContact(name, email, phone)
            }
            EventBus.getDefault().post(RefreshListEvent())
            view?.onContactSaved()
        }
    }

    override fun onDestroy() {
        view = null
    }
}