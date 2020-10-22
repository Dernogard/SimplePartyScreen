package ru.dernogard.simplepartyscreen

import android.app.Application
import android.content.Context

/**
 *  I should use that way because I won't use any DI but I need a context for some app's features
 *  It's not affected on memory leak
 */

class App: Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}