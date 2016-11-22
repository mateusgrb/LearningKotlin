package com.example.learningkotlin.data.source

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.local.ContactsLocalDataSource

/**
 * Created by mateus on 10/11/16.
 */
class ContactsRepository : ContactsDataSource {
    val localDataSource: ContactsDataSource = ContactsLocalDataSource()

    override fun insertContact(name: String, email: String, phone: String) {
        localDataSource.insertContact(name, email, phone)
    }

    override fun updateContact(id: Long, name: String, email: String, phone: String) {
        localDataSource.updateContact(id, name, email, phone)
    }

    override fun getContacts(): List<Contact> {
        return localDataSource.getContacts()
    }

    override fun deleteContacts(contacts: List<Contact>) {
        localDataSource.deleteContacts(contacts)
    }
}