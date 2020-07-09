package com.tasneembohra.github.ui.search.di

import com.tasneembohra.github.repo.Repository
import com.tasneembohra.github.ui.search.UserSearchFragment
import com.tasneembohra.github.ui.search.UserSearchViewModel
import com.tasneembohra.github.util.getViewModel
import dagger.Module
import dagger.Provides

@Module
class UserSearchFragmentModule {

    @Provides
    fun provideViewModel(fragment: UserSearchFragment, repo: Repository) =
        fragment.getViewModel { UserSearchViewModel(repo) }
}