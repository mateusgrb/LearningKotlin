package com.example.learningkotlin.contacts

/**
 * Created by mateus on 08/11/16.
 */
class ContactsPresenter(private var view: ContactsContract.View?) : ContactsContract.Presenter {

    override fun onDestroy() {
        view = null
    }

    override fun addNewContact() {
        view?.showAddContactScreen()
    }
}