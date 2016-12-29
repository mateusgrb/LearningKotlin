package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.business.EventHandler
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.data.source.ContactsRepository
import com.example.learningkotlin.utils.Validator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mateus on 25/12/16.
 */
@Module
class AddEditContactPresenterModule(val view: AddEditContactContract.View) {

    @Provides @Singleton fun provideView() = view

    @Provides fun provideContactsDataSource() : ContactsDataSource = ContactsRepository()

    @Provides @Singleton fun provideValidator(): Validator = Validator()

    @Provides @Singleton fun provideEventHandler() = EventHandler()

    @Provides @Singleton fun providePresenter(view: AddEditContactContract.View, repository:
    ContactsDataSource, validator: Validator, eventHandler: EventHandler): AddEditContactContract.Presenter =
            AddEditContactPresenter(view, repository, validator, eventHandler)
}