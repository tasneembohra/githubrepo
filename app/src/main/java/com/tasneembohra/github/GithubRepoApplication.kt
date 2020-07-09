package com.tasneembohra.github

import android.app.Activity
import android.app.Application
import com.tasneembohra.github.di.*
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class GithubRepoApplication : Application(), HasActivityInjector {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        applicationComponent = buildAppComponent()
        applicationComponent.inject(this)
    }
    
    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    private fun buildAppComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}