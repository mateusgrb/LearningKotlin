package com.example.learningkotlin.addeditcontact

import android.net.Uri
import android.util.Log
import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.events.RefreshListEvent
import com.example.learningkotlin.utils.Validator
import org.greenrobot.eventbus.EventBus

/**
 * Created by mateus on 09/11/16.
 */

class AddEditContactPresenter(private var view: AddEditContactContract.View?) :
        AddEditContactContract.Presenter {

    private val repository: ContactsRepository = ContactsRepository()
    private var newImageSelected = false

    override fun saveContact(contact: Contact, imageUri: Uri?) {
        if (!Validator.validateContactName(contact.name)) {
            view?.showContactNameError()
        } else if (!Validator.validateContactEmail(contact.email)) {
            view?.showContactEmailError()
        } else if (!Validator.validateContactPhone(contact.phone)) {
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
        EventBus.getDefault().post(RefreshListEvent())
        view?.onContactSaved()
    }
}