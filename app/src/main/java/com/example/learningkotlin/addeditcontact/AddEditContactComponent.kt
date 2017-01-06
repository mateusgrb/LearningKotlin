package com.example.learningkotlin.addeditcontact

import com.example.learningkotlin.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mateus on 25/12/16.
 */
@Singleton
@Component(modules = arrayOf(AddEditContactPresenterModule::class, AppModule::class))
interface AddEditContactComponent {

    fun inject(activity: AddEditContactActivity)
}