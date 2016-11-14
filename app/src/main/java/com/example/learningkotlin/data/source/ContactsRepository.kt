package com.example.learningkotlin.data.source

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.local.ContactsLocalDataSource

/**
 * Created by mateus on 10/11/16.
 */
class ContactsRepository : ContactsDataSource {
    val localDataSource: ContactsDataSource = ContactsLocalDataSource()

    override fun insertContact(name: String, age: Int, sex: String) {
        localDataSource.insertContact(name, age, sex)
    }

    override fun updateContact(id: Long, name: String, age: Int, sex: String) {
        localDataSource.updateContact(id, name, age, sex)
    }

    override fun getContacts(): List<Contact> {
        return localDataSource.getContacts()
    }
}