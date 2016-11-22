package com.example.learningkotlin.data.source

import com.example.learningkotlin.data.models.Contact

/**
 * Created by mateus on 10/11/16.
 */
interface ContactsDataSource {

    fun insertContact(name: String, email: String, phone: String)
    fun updateContact(id: Long, name: String, email: String, phone: String)
    fun getContacts(): List<Contact>
    fun deleteContacts(contacts: List<Contact>)
}