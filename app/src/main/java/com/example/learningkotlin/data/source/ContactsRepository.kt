package com.example.learningkotlin.data.source

import android.net.Uri
import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.local.ContactsLocalDataSource
import com.example.learningkotlin.data.source.remote.ContactsFirebaseDataSource

/**
 * Created by mateus on 10/11/16.
 */
class ContactsRepository : ContactsDataSource {

    val localDataSource: ContactsLocalDataSource = ContactsLocalDataSource()
    val remoteDataSource: ContactsFirebaseDataSource = ContactsFirebaseDataSource()

    override fun insertContact(contact: Contact) {
        localDataSource.insertContact(contact)
    }

    override fun updateContact(contact: Contact) {
        localDataSource.updateContact(contact)
    }

    override fun getContacts(): List<Contact> {
        return localDataSource.getContacts()
    }

    override fun deleteContacts(contacts: List<Contact>) {
        localDataSource.deleteContacts(contacts)
    }

    override fun uploadImage(imageUri: Uri, listener: ContactsDataSource.UploadResultListener) {
        remoteDataSource.uploadImage(imageUri, listener)
    }
}