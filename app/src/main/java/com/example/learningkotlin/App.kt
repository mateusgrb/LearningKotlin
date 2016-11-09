package com.example.learningkotlin

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * Created by mateus on 09/11/16.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
    }
}