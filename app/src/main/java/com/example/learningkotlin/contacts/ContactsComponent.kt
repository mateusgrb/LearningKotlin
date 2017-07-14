package com.example.learningkotlin.contacts

import com.example.learningkotlin.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mateus on 12/07/17.
 */
@Singleton
@Component(modules = arrayOf(ContactsPresenterModule::class, AppModule::class))
interface ContactsComponent {

    fun inject(activity: ContactsActivity)
}