package com.tasneembohra.github.remote

import com.tasneembohra.github.remote.model.RepoResponse
import com.tasneembohra.github.remote.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{userId}")
    suspend fun fetchUserDetail(@Path("userId") userId: String): UserResponse

    @GET("users/{userId}/repos")
    suspend fun fetchUserRepos(@Path("userId") userId: String): List<RepoResponse>
}