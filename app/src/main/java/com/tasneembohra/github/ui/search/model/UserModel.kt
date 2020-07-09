package com.tasneembohra.github.ui.search.model

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.tasneembohra.github.repo.UserDataModel

class UserModel(val loading: ObservableBoolean = ObservableBoolean(true)) {
    val data = ObservableField<UserDataModel>()
}