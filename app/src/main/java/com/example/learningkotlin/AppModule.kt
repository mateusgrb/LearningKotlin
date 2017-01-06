package com.example.learningkotlin

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mateus on 06/01/17.
 */
@Module
class AppModule(val context: Context) {

    @Provides @Singleton fun provideContext() = context.applicationContext
}