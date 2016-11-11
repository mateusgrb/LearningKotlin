package com.example.learningkotlin.data.source

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.local.ContactsLocalDataSource

/**
 * Created by mateus on 10/11/16.
 */
class ContactsRepository : ContactsDataSource {

    val localDataSource: ContactsDataSource = ContactsLocalDataSource()

    override fun insertContact() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContacts(): List<Contact> {
        return localDataSource.getContacts()
    }
}