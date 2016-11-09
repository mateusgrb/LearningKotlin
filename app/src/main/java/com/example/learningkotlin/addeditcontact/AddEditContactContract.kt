package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.BasePresenter
import com.example.learningkotlin.BaseView

/**
 * Created by mateus on 09/11/16.
 */

interface AddEditContactContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

        fun getSexValues(): List<String>
        fun saveContact()
    }
}