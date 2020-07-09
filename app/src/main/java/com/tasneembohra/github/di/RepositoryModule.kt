package com.tasneembohra.github.di

import com.tasneembohra.github.remote.ApiProvider
import com.tasneembohra.github.repo.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(apiProvider: ApiProvider): Repository {
        return Repository(apiProvider)
    }
}