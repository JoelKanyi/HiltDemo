package com.kanyideveloper.hiltdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kanyideveloper.hiltdemo.R
import com.kanyideveloper.hiltdemo.model.DiffUtilGithubDataModel
import com.kanyideveloper.hiltdemo.model.GithubDataModel

class RepositoriesAdapter : ListAdapter<GithubDataModel.GithubDataModelItem, RepositoriesViewHolder>(DiffUtilGithubDataModel()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        return RepositoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repos_row, parent, false))
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}