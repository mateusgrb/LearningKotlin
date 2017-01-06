package com.example.learningkotlin.data.source

import com.example.learningkotlin.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mateus on 06/01/17.
 */
@Singleton
@Component(modules = arrayOf(ContactsRepositoryModule::class, AppModule::class))
interface ContactsRepositoryComponent {

    fun inject(repository: ContactsRepository)
}