package com.example.learningkotlin.contacts

import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView
import com.example.learningkotlin.data.models.Contact

/**
 * Created by mateus on 09/11/16.
 */

interface ContactsContract {

    interface View : BaseView<Presenter> {

        fun showAddContactScreen()
        fun refreshList(contacts: List<Contact>)
    }

    interface Presenter : BasePresenter {

        fun addNewContact()
        fun getContacts(): List<Contact>
        fun deleteContacts(contactsToBeDeleted: List<Contact>)
    }
}
