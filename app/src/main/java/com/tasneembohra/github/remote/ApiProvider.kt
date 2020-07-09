package com.tasneembohra.github.remote

import com.tasneembohra.github.repo.RepoDataModel
import com.tasneembohra.github.repo.UserDataModel

class ApiProvider(private val api: ApiService) {

    suspend fun fetchUserInfo(userId: String): Result<UserDataModel> {
        kotlin.runCatching {
            api.fetchUserDetail(userId)
        }.onFailure {
            return ErrorState(ErrorModel())
        }.onSuccess {
            return SuccessState(it.build())
        }
        return LoadingState()
    }

    suspend fun fetchUserRepoInfo(userId: String): Result<List<RepoDataModel>> {
        kotlin.runCatching {
            api.fetchUserRepos(userId)
        }.onFailure {
            return ErrorState(ErrorModel())
        }.onSuccess { response ->
            return SuccessState(response.map { it.build() })
        }
        return LoadingState()
    }
}