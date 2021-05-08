package com.kanyideveloper.hiltdemo.model

import androidx.recyclerview.widget.DiffUtil

class DiffUtilGithubDataModel :
    DiffUtil.ItemCallback<GithubDataModel.GithubDataModelItem>() {
    override fun areItemsTheSame(
        oldItem: GithubDataModel.GithubDataModelItem,
        newItem: GithubDataModel.GithubDataModelItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: GithubDataModel.GithubDataModelItem,
        newItem: GithubDataModel.GithubDataModelItem
    ): Boolean {
        return newItem == oldItem
    }
}