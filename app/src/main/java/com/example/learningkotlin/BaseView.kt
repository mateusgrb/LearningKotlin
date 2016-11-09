package com.example.learningkotlin

/**
 * Created by mateus on 09/11/16.
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}
