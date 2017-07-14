package com.example.learningkotlin.contacts

import android.content.Context
import com.example.learningkotlin.business.EventHandler
import com.example.learningkotlin.data.source.ContactsDataSource
import com.example.learningkotlin.data.source.ContactsRepository
import dagger.Module
import dagger.Provides

/**
 * Created by mateus on 12/07/17.
 */
@Module
class ContactsPresenterModule(val view: ContactsContract.View) {

    @Provides fun provideView() = view

    @Provides fun provideContactsDataSource(context: Context): ContactsDataSource =
            ContactsRepository(context)

    @Provides fun provideEventHandler() = EventHandler()

    @Provides fun providePresenter(view: ContactsContract.View, repository: ContactsDataSource,
                                   eventHandler: EventHandler): ContactsContract.Presenter =
            ContactsPresenter(view, repository, eventHandler)
}