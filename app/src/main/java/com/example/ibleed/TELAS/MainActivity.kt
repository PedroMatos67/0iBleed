package com.example.ibleed.TELAS

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.ibleed.Constantes.TestContans
import com.example.ibleed.NEgocios.UserBusniess

import com.example.ibleed.R

import com.example.ibleed.adapter.UsersListAdapter
import com.example.ibleed.util.SecurityPreferences

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var mSecurityPreferences: SecurityPreferences
    private lateinit var mRecycleViewList: RecyclerView
    private lateinit var mUserBusiness: UserBusniess
    private lateinit var mListener: onUsersListInteraction

    private val LOG_TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSecurityPreferences = SecurityPreferences(this)
        formatUserName()
        setListteners()
        imageSelected(R.id.imageHome)



        mUserBusiness = UserBusniess(this)



        //1 obtendo a recycle
        mRecycleViewList = findViewById(R.id.recycliUserList)
        //2 denindo um adapter com os itens de listagem
        mRecycleViewList.adapter = UsersListAdapter(mUserBusiness.getList())


          //3 denindo layou
        mRecycleViewList.layoutManager = LinearLayoutManager(this)

    }



    override fun onResume() {
        super.onResume()
    loadUsers()
             }

                       private fun loadUsers(){
                            mRecycleViewList.adapter = UsersListAdapter(mUserBusiness.getList())

                       }



    //Elemento clicado
    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.imageHome) {
            imageSelected(id)
            onResume()
           // loadUsers()

        }
        if (id == R.id.imagePerfil) {
           // imageSelected(id)
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)


        }
        if (id == R.id.imageNotifications) {
            //imageSelected(id)
            val intent = Intent(this, NoficationActivity::class.java)
            startActivity(intent)


        }

    }

    private fun setListteners() {
        imageHome.setOnClickListener(this)
        imagePerfil.setOnClickListener(this)
        imageNotifications.setOnClickListener(this)


    }


    private fun formatUserName(){
        val str = "Bem vindo ${mSecurityPreferences.getStoreString(TestContans.KEY.USER_NAME)}!"
        textHello.text = str
    }


    private fun imageSelected(id: Int) {

        imageHome.setImageResource(R.drawable.ic_home_black_24dp)
        imageNotifications.setImageResource(R.drawable.ic_notifications_black_24dp)
        imagePerfil.setImageResource(R.drawable.ic_person_black_24dp)
        if (id == R.id.imageHome) {

            imageHome.setImageResource(R.drawable.ic_home_selected_24dp)


        } else if (id == R.id.imagePerfil) {
            imagePerfil.setImageResource(R.drawable.ic_person_selected_24dp)
        } else {
            imageNotifications.setImageResource(R.drawable.ic_notifications_selected_24dp)
        }

    }


}





