package com.tasneembohra.github.di

import com.tasneembohra.github.ui.HomeStructureModule
import com.tasneembohra.github.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationStructureModule {

    @ContributesAndroidInjector(modules = [HomeStructureModule::class])
    abstract fun bindHomeActivity(): MainActivity

}