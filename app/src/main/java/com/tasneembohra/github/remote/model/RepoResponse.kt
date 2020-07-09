package com.tasneembohra.github.remote.model

import com.google.gson.annotations.SerializedName
import com.tasneembohra.github.remote.IBaseResponse
import com.tasneembohra.github.repo.RepoDataModel

class RepoResponse(
    @SerializedName("name") val repoName: String,
    @SerializedName("description") val description: String?, // As per the api response, description can be null
    @SerializedName("stargazers_count") val starCount: Int,
    @SerializedName("forks") val forksCount: Int,
    @SerializedName("updated_at") val updateDate: GithubDate?
) : IBaseResponse<RepoDataModel> {

    override fun build() = RepoDataModel(
        repoName,
        description ?: "",
        updateDate?.date ?: "",
        starCount,
        forksCount
    )
}