package com.example.learningkotlin.addeditcontact

import dagger.Component
import javax.inject.Singleton

/**
 * Created by mateus on 25/12/16.
 */
@Singleton
@Component(modules = arrayOf(AddEditContactPresenterModule::class))
interface AddEditContactComponent {

    fun getPresenter(): AddEditContactContract.Presenter
}