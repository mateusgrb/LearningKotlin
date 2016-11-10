package com.example.learningkotlin.contacts

import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView

/**
 * Created by mateus on 09/11/16.
 */

interface ContactsContract {

    interface View : BaseView<Presenter> {

        fun showAddContactScreen()
    }

    interface Presenter : BasePresenter {

        fun addNewContact()
    }
}
