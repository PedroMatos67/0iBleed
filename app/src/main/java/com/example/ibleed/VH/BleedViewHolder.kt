package com.example.ibleed.VH

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.OrientationEventListener
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.ibleed.Entidades.UserEntity
import com.example.ibleed.R
import com.example.ibleed.TELAS.onUsersListInteraction

import org.w3c.dom.Text

class BleedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val mTextDescription: TextView = itemView.findViewById(R.id.textDescription)
    private val mTextBloodType : TextView = itemView.findViewById(R.id.textBloodType)


    private lateinit var mListener: onUsersListInteraction
    fun bindData(users: UserEntity) {
        mTextDescription.text = users.name
        mTextBloodType.text = users.blood.toUpperCase()




    }



}