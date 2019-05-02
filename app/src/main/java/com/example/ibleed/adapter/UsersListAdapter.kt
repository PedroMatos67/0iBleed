package com.example.ibleed.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ibleed.Entidades.UserEntity
import com.example.ibleed.R
import com.example.ibleed.VH.BleedViewHolder
import java.text.FieldPosition

class UsersListAdapter (val usersList: List<UserEntity>): RecyclerView.Adapter <BleedViewHolder>() {

    override fun onBindViewHolder(holder: BleedViewHolder, position: Int) {

        val users = usersList[position]
        holder.bindData(users)

    }

//criando linhas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BleedViewHolder {
        val context = parent?.context
            val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_user_list, parent, false)

        return BleedViewHolder(view)

    }




    override fun getItemCount(): Int {
        return usersList.count()
    }
}