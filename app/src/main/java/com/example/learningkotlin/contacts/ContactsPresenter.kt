package com.example.learningkotlin.contacts

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsRepository

/**
 * Created by mateus on 08/11/16.
 */
class ContactsPresenter(private var view: ContactsContract.View?) : ContactsContract.Presenter {

    val repository: ContactsRepository = ContactsRepository()

    override fun onDestroy() {
        view = null
    }

    override fun addNewContact() {
        view?.showAddContactScreen()
    }

    override fun getContacts(): List<Contact> {
        return repository.getContacts()
    }

    override fun deleteContacts(contacts: List<Contact>) {
        repository.deleteContacts(contacts)
    }
}