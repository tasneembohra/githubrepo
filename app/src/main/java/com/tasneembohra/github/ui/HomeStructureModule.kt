package com.tasneembohra.github.ui

import com.tasneembohra.github.ui.search.UserSearchFragment
import com.tasneembohra.github.ui.search.di.UserSearchFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeStructureModule {
    @ContributesAndroidInjector(modules = [UserSearchFragmentModule::class])
    abstract fun bindUserSearchFragment(): UserSearchFragment
}