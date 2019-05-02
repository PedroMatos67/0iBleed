package com.example.ibleed.TELAS

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.ibleed.R
import com.example.ibleed.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class NoficationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nofication)
        setListteners()
        handleFilter(R.id.imageNotifications)
    }
    override fun onClick(view: View){
        val id = view.id

        if (id== R.id.imageHome){
            handleFilter(id)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (id== R.id.imagePerfil){
            handleFilter(id)
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()

        }

        if (id == R.id.imageNotifications){
            handleFilter(id)


        }

    }
    private fun setListteners(){
        imageHome.setOnClickListener(this)
        imagePerfil.setOnClickListener(this)
        imageNotifications.setOnClickListener(this)

    }


    private fun handleFilter(id: Int){

        imageHome.setImageResource(R.drawable.ic_home_black_24dp)
        imageNotifications.setImageResource(R.drawable.ic_notifications_black_24dp)
        imagePerfil.setImageResource(R.drawable.ic_person_black_24dp)
        if (id == R.id.imageHome){

            imageHome.setImageResource(R.drawable.ic_home_selected_24dp)


        }else if (id == R.id.imagePerfil){
            imagePerfil.setImageResource(R.drawable.ic_person_selected_24dp)
        }else{
            imageNotifications.setImageResource(R.drawable.ic_notifications_selected_24dp)
        }

    }
}

