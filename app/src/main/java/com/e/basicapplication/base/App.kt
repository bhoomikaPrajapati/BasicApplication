package com.e.basicapplication.base

import android.app.Application

class App : Application() {

    companion object {
         var appContext: App?=null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}