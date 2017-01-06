package com.example.learningkotlin.data.source

import android.content.Context
import com.example.learningkotlin.data.source.local.ContactsLocalDataSource
import com.example.learningkotlin.data.source.remote.ContactsFirebaseDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by mateus on 06/01/17.
 */
@Module
class ContactsRepositoryModule {

    @Provides fun provideContactsLocalDataSource() = ContactsLocalDataSource()

    @Provides fun provideContactsFirebaseDataSource(context: Context) =
            ContactsFirebaseDataSource(context)
}