package com.tasneembohra.github.repo

import com.tasneembohra.github.remote.ApiProvider

class Repository(private val apiProvider: ApiProvider) {

    suspend fun fetchUserInfo(userId: String) = apiProvider.fetchUserInfo(userId)

    suspend fun fetchUserRepDetails(userId: String) = apiProvider.fetchUserRepoInfo(userId)

}