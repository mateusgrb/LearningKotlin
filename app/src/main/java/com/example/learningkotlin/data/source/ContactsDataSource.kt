package com.example.learningkotlin.data.source

import android.net.Uri
import com.example.learningkotlin.data.models.Contact

/**
 * Created by mateus on 10/11/16.
 */
interface ContactsDataSource {

    fun insertContact(contact: Contact)
    fun updateContact(contact: Contact)
    fun getContacts(): List<Contact>
    fun deleteContacts(contacts: List<Contact>)
    fun uploadImage(imageUri: Uri, listener: UploadResultListener)

    interface UploadResultListener {
        fun onSuccess(downloadUrl: Uri?)
        fun onError(exception: Exception)
    }
}