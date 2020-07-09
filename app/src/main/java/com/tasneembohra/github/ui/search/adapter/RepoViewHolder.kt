package com.tasneembohra.github.ui.search.adapter

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.tasneembohra.github.databinding.ItemRepoInfoBinding
import com.tasneembohra.github.repo.RepoDataModel
import com.tasneembohra.github.ui.search.model.RepoModel

class RepoViewHolder(
    private val binding: ItemRepoInfoBinding,
    private val clickLiveData: MutableLiveData<RepoDataModel>
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    lateinit var dataModel: RepoDataModel

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(model: RepoModel) {
        binding.model = model
        dataModel = model.data
        binding.executePendingBindings()
    }

    override fun onClick(v: View?) {
        clickLiveData.value = dataModel
    }
}