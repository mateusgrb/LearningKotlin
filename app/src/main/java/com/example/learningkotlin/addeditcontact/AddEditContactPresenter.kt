package com.example.learningkotlin.addeditcontact

import android.net.Uri
import android.util.Log
import com.example.learningkotlin.business.EventHandler
import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.events.RefreshListEvent
import com.example.learningkotlin.utils.Validator

/**
 * Created by mateus on 09/11/16.
 */

class AddEditContactPresenter(view: AddEditContactContract.View?, private val repository:
ContactsDataSource, private val validator: Validator, private val eventHandler: EventHandler) :
        AddEditContactContract.Presenter {

    var view: AddEditContactContract.View? = view
        private set
    private var newImageSelected = false

    override fun saveContact(contact: Contact, imageUri: Uri?) {
        if (!validator.validateContactName(contact.name)) {
            view?.showContactNameError()
        } else if (!validator.validateContactEmail(contact.email)) {
            view?.showContactEmailError()
        } else if (!validator.validateContactPhone(contact.phone)) {
            view?.showContactPhoneError()
        } else {
            if (newImageSelected && imageUri != null) {
                repository.uploadImage(imageUri, object : ContactsDataSource.UploadResultListener {
                    override fun onSuccess(downloadUrl: Uri?) {
                        contact.pictureUrl = downloadUrl.toString()
                        saveContact(contact)
                    }

                    override fun onError(exception: Exception) {
                        Log.e("AddEditContactPresenter", "Failed to upload file", exception)
                    }
                })
            } else {
                saveContact(contact)
            }
        }
    }

    override fun onImageSelected() {
        newImageSelected = true
    }

    override fun onDestroy() {
        view = null
    }

    private fun saveContact(contact: Contact) {
        if (contact.id > 0) {
            repository.updateContact(contact)
        } else {
            repository.insertContact(contact)
        }
        eventHandler.send(RefreshListEvent())
        view?.onContactSaved()
    }
}