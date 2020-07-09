package com.tasneembohra.github.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.tasneembohra.github.databinding.ItemRepoInfoBinding
import com.tasneembohra.github.repo.RepoDataModel
import com.tasneembohra.github.ui.search.model.RepoModel

class RepoAdapter(
    private var list: List<RepoModel> = emptyList()
) : RecyclerView.Adapter<RepoViewHolder>() {

    private val _clickLiveData: MutableLiveData<RepoDataModel> = MutableLiveData()
    val clickLiveData: LiveData<RepoDataModel>
        get() = _clickLiveData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            ItemRepoInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            _clickLiveData
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(list: List<RepoModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}
