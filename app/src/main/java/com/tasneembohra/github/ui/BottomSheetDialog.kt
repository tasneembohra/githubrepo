package com.tasneembohra.github.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tasneembohra.github.R
import com.tasneembohra.github.databinding.DialogRepoDetailBinding
import com.tasneembohra.github.repo.RepoDataModel

class BottomSheetDialog : BottomSheetDialogFragment() {

    companion object {
        const val BUNDLE_DATA = "data"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogRepoDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.dialog_repo_detail, container, false)

        arguments?.getParcelable<RepoDataModel>(BUNDLE_DATA)?.let { binding.data = it }

        return binding.root
    }
}