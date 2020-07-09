package com.tasneembohra.github.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return app.applicationContext
    }
}