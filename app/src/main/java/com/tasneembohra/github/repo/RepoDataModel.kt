package com.tasneembohra.github.repo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RepoDataModel(
    val name: String = "",
    val description: String = "",
    val updatedAt: String = "",
    val stars: Int = 0,
    val forks: Int = 0
) : Parcelable