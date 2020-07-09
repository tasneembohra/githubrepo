package com.tasneembohra.github.di

import com.tasneembohra.github.GithubRepoApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class, NetworkModule::class, RepositoryModule::class,
        AndroidInjectionModule::class, ApplicationStructureModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun applicationModule(module: ApplicationModule): Builder
        fun networkModule(module: NetworkModule): Builder
        fun repositoryModule(module: RepositoryModule): Builder
        fun build(): ApplicationComponent
    }

    fun inject(application: GithubRepoApplication)
}