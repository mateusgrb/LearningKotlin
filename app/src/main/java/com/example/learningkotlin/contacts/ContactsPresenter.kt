package com.example.learningkotlin.contacts

import com.example.learningkotlin.data.models.Contact
import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.events.RefreshListEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by mateus on 08/11/16.
 */
class ContactsPresenter(private var view: ContactsContract.View?) : ContactsContract.Presenter {

    val repository: ContactsRepository = ContactsRepository()

    init {
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
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