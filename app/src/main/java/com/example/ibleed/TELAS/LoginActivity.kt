package com.example.ibleed.TELAS

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.ibleed.Constantes.TestContans
import com.example.ibleed.NEgocios.UserBusniess
import com.example.ibleed.R
import com.example.ibleed.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserBusniess: UserBusniess
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //instanciar as variaveis da classe
        mUserBusniess = UserBusniess(this)
        mSecurityPreferences = SecurityPreferences(this)

        setListeners()
        verifyLogger()

    }

    override fun onClick(view: View) {
      when(view.id){
                   R.id.buttonLogin ->{
                    handleLogin()
                                }
}
    }


    private fun setListeners(){

        buttonLogin.setOnClickListener(this)

    }

    private fun verifyLogger(){
        val id = mSecurityPreferences.getStoreString(TestContans.KEY.USER_ID)
        val name = mSecurityPreferences.getStoreString(TestContans.KEY.USER_NAME)

        if (id !="" && name != ""){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    private fun handleLogin(){
        val email = Email.text.toString()
        val password = editSenha.text.toString()

          if  (mUserBusniess.login(email, password)){

              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)
              finish()
          }else{
              Toast.makeText(this, getString(R.string.email_ou_senha_incorreto), Toast.LENGTH_LONG).show()
          }

    }
}
