package com.example.learningkotlin.contacts

import com.example.learningkotlin.business.EventHandler
import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.events.RefreshListEvent
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by mateus on 08/11/16.
 */
class ContactsPresenter(view: ContactsContract.View?, private val repository:
ContactsDataSource, private val eventHandler: EventHandler) : ContactsContract.Presenter {

    var view: ContactsContract.View? = view
        private set

    init {
        eventHandler.register(this)
    }

    override fun onDestroy() {
        eventHandler.unregister(this)
        view = null
    }

    override fun addNewContact() {
        view?.showAddContactScreen()
    }

    override fun getContacts(): List<Contact> {
        return repository.getContacts()
    }

    override fun deleteContacts(contactsToBeDeleted: List<Contact>) {
        repository.deleteContacts(contactsToBeDeleted)
        view?.refreshList(getContacts())
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshListEvent(event: RefreshListEvent) {
        view?.refreshList(getContacts())
    }
}