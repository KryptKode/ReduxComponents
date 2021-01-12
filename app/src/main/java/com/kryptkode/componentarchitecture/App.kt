package com.kryptkode.componentarchitecture

import android.app.Application
import timber.log.Timber

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}