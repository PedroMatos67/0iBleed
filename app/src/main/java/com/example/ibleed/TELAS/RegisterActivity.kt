package com.example.ibleed.TELAS

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ibleed.NEgocios.UserBusniess
import com.example.ibleed.R
import com.example.ibleed.util.ExeptionValidacion
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


private lateinit var mUserBusniess : UserBusniess


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       setListener()

        //instanciar variaveis da classe
        mUserBusniess = UserBusniess(this)

    }
    override fun onClick(view: View) {

        when(view.id){
            R.id.buttonastro ->{
                handleSave()


            }
        }
    }



    private fun setListener(){
        buttonastro.setOnClickListener(this)
    }

  private fun handleSave(){

   try {
       val name = textName.text.toString()
       val email = Email.text.toString()
       val password = editSenha.text.toString()
       val blood = Sangue.text.toString()


//inserção do usuario
       mUserBusniess.insert(name, email, password, blood)
       val intent = Intent(this, MainActivity::class.java)
       startActivity(intent)
       finish()

   }catch (e: ExeptionValidacion){
       Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
   }catch (e: Exception){
       Toast.makeText(this, getString(R.string.erro_inesperado), Toast.LENGTH_LONG).show()

   }
}
    }