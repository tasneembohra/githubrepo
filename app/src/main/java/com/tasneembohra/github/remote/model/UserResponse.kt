package com.tasneembohra.github.remote.model

import com.google.gson.annotations.SerializedName
import com.tasneembohra.github.remote.IBaseResponse
import com.tasneembohra.github.repo.UserDataModel

class UserResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("avatar_url") val avatar: String?
) : IBaseResponse<UserDataModel> {

    override fun build() = UserDataModel(name ?: "", avatar ?: "")
}