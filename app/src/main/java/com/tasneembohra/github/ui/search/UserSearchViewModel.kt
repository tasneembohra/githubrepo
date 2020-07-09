package com.tasneembohra.github.ui.search

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasneembohra.github.remote.ErrorState
import com.tasneembohra.github.remote.SuccessState
import com.tasneembohra.github.repo.Repository
import com.tasneembohra.github.repo.UserDataModel
import com.tasneembohra.github.ui.search.model.RepoModel
import com.tasneembohra.github.ui.search.model.UserModel
import kotlinx.coroutines.launch

class UserSearchViewModel(private val repo: Repository) : ViewModel() {

    val user = UserModel()
    val showUserView = ObservableBoolean(false)
    val isErrorState = ObservableBoolean(false)


    private val _repoLiveData = MutableLiveData<List<RepoModel>>()
    val repoLiveData: LiveData<List<RepoModel>>
        get() = _repoLiveData

    fun search(userId: String) {
        user.loading.set(true)
        isErrorState.set(false)
        _repoLiveData.postValue(
            listOf(
                RepoModel(loading = true),
                RepoModel(loading = true),
                RepoModel(loading = true),
                RepoModel(loading = true),
                RepoModel(loading = true),
                RepoModel(loading = true)
            )
        )
        showUserView.set(true)
        fetchUserInfo(userId)
        fetchUserRepo(userId)
    }

    private fun fetchUserInfo(userId: String) = viewModelScope.launch {
        when (val result = repo.fetchUserInfo(userId)) {
            is SuccessState -> {
                isErrorState.set(false)
                user.loading.set(false)
                user.data.set(result.data)
            }
            is ErrorState -> {
                user.loading.set(false)
                user.data.set(UserDataModel())
                isErrorState.set(true)
            }
        }
    }

    private fun fetchUserRepo(userId: String) = viewModelScope.launch {
        when (val result = repo.fetchUserRepDetails(userId)) {
            is SuccessState -> {
                _repoLiveData.value = result.data.map { RepoModel(data = it) }
            }
            is ErrorState -> {
                isErrorState.set(true)
                _repoLiveData.value = emptyList()
            }
        }

    }


}