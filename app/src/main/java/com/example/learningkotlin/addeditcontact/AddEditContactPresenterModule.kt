package com.example.learningkotlin.addeditcontact

import android.content.Context
import com.example.learningkotlin.business.EventHandler
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.utils.Validator
import dagger.Module
import dagger.Provides

/**
 * Created by mateus on 25/12/16.
 */
@Module
class AddEditContactPresenterModule(val view: AddEditContactContract.View) {

    @Provides fun provideView() = view

    @Provides fun provideContactsDataSource(context: Context): ContactsDataSource =
            ContactsRepository(context)

    @Provides fun provideValidator(): Validator = Validator()

    @Provides fun provideEventHandler() = EventHandler()

    @Provides fun providePresenter(view: AddEditContactContract.View, repository:
    ContactsDataSource, validator: Validator, eventHandler: EventHandler): AddEditContactContract.Presenter =
            AddEditContactPresenter(view, repository, validator, eventHandler)
}