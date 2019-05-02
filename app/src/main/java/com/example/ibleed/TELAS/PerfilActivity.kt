package com.example.ibleed.TELAS

import android.content.Intent
import android.content.pm.PackageInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ibleed.Constantes.TestContans
import com.example.ibleed.R
import com.example.ibleed.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private lateinit var mPackageInfo: PackageInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        mSecurityPreferences = SecurityPreferences(this)


         formatUserName()

    }



    override fun onClick(view: View) {



    }

    fun logoutUser(view: View): Boolean {
        handleLogout()
        finish()
        return false
    }

    private fun formatUserName() {
        val str = "${mSecurityPreferences.getStoreString(TestContans.KEY.USER_NAME)}"
        textUsuarioNome.text = str

        val str2 = "${mSecurityPreferences.getStoreString(TestContans.KEY.USER_TYPE)}"
        textUserBlood.text = str2.toUpperCase()
    }


    private fun handleLogout() {
        //apagar
        mSecurityPreferences.removeStoreString(TestContans.KEY.USER_ID)
        mSecurityPreferences.removeStoreString(TestContans.KEY.USER_NAME)
        mSecurityPreferences.removeStoreString(TestContans.KEY.USER_TYPE)
        mSecurityPreferences.removeStoreString(TestContans.KEY.USER_EMAIL)


        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
        finish()
    }










}
