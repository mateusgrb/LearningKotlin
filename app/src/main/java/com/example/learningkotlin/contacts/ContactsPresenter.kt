package com.example.learningkotlin.contacts

/**
 * Created by mateus on 08/11/16.
 */
class ContactsPresenter(var activity: ContactsActivity?) : ContactsContract.Presenter {

    override fun onDestroy() {
        activity = null
    }

    override fun addNewContact() {

    }
}