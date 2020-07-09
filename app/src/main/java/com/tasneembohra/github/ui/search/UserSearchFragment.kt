package com.tasneembohra.github.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tasneembohra.github.R
import com.tasneembohra.github.databinding.FragmentUserSearchBinding
import com.tasneembohra.github.ui.BottomSheetDialog
import com.tasneembohra.github.ui.search.adapter.RepoAdapter
import com.tasneembohra.github.util.addSpaceItemDecor
import kotlinx.android.synthetic.main.fragment_user_search.*
import javax.inject.Inject

class UserSearchFragment : com.stayopn.di.application.DaggerFragment() {

    @Inject
    lateinit var viewModel: UserSearchViewModel

    lateinit var binding: FragmentUserSearchBinding

    private val adapter = RepoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_search, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.user = viewModel.user
        binding.showUserView = viewModel.showUserView
        binding.isError = viewModel.isErrorState
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerview.apply {
            addSpaceItemDecor(R.dimen.recyclerview_space)
            adapter = this@UserSearchFragment.adapter
        }

        etSearch.searchTextLiveData.observe(viewLifecycleOwner, Observer { userId ->
            viewModel.search(userId)
        })

        viewModel.repoLiveData.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })

        adapter.clickLiveData.observe(viewLifecycleOwner, Observer {
            Bundle().apply {
                putParcelable(BottomSheetDialog.BUNDLE_DATA, it)
            }.let { findNavController().navigate(R.id.bottomSheetDialog, it) }
        })
    }

}