package com.kanyideveloper.hiltdemo.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.hiltdemo.R
import com.kanyideveloper.hiltdemo.model.GithubDataModel

class RepositoriesViewHolder(itemView: View) :
RecyclerView.ViewHolder(itemView){
    fun bind(item: GithubDataModel.GithubDataModelItem?) {
        val repoName = itemView.findViewById<TextView>(R.id.repoName)
        val repoDescription = itemView.findViewById<TextView>(R.id.repoDescription)

        repoName.text = item?.name
        repoDescription.text = item?.description

    }
}