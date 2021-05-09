package com.kanyideveloper.hiltdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.hiltdemo.R
import com.kanyideveloper.hiltdemo.model.Opensource254ReposModel

class RepositoriesAdapter :
    ListAdapter<Opensource254ReposModel.Opensource254ReposModelItem, RepositoriesAdapter.RepositoriesViewHolder>(
        DiffUtilGithubDataModel()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        return RepositoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repos_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Opensource254ReposModel.Opensource254ReposModelItem?) {
            val repoName = itemView.findViewById<TextView>(R.id.repoName)
            val repoDescription = itemView.findViewById<TextView>(R.id.repoDescription)

            repoName.text = item?.name
            repoDescription.text = item?.description

        }
    }

    class DiffUtilGithubDataModel :
        DiffUtil.ItemCallback<Opensource254ReposModel.Opensource254ReposModelItem>() {
        override fun areItemsTheSame(
            oldItem: Opensource254ReposModel.Opensource254ReposModelItem,
            newItem: Opensource254ReposModel.Opensource254ReposModelItem
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: Opensource254ReposModel.Opensource254ReposModelItem,
            newItem: Opensource254ReposModel.Opensource254ReposModelItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}