package com.kanyideveloper.hiltdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.hiltdemo.R
import com.kanyideveloper.hiltdemo.model.GithubDataModel

class RepositoriesAdapter : ListAdapter<GithubDataModel.GithubDataModelItem, RepositoriesAdapter.RepositoriesViewHolder>(DiffUtilGithubDataModel()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        return RepositoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repos_row, parent, false))
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: GithubDataModel.GithubDataModelItem?) {
            val repoName = itemView.findViewById<TextView>(R.id.repoName)
            val repoDescription = itemView.findViewById<TextView>(R.id.repoDescription)

            repoName.text = item?.name
            repoDescription.text = item?.description

        }
    }

    class DiffUtilGithubDataModel : DiffUtil.ItemCallback<GithubDataModel.GithubDataModelItem>() {
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
}