package com.example.ibleed.NEgocios

import android.content.Context
import com.example.ibleed.Constantes.TestContans
import com.example.ibleed.Entidades.UserEntity
import com.example.ibleed.R
import com.example.ibleed.Repositorio.UserRepository
import com.example.ibleed.util.ExeptionValidacion
import com.example.ibleed.util.SecurityPreferences
import java.lang.Exception

class UserBusniess(val context: Context) {

    private val mUserRepository: UserRepository = UserRepository.getInstance(context)
    private val mSecurityPreferences: SecurityPreferences = SecurityPreferences(context)

    fun login (email: String, password: String): Boolean{

        val user: UserEntity? = mUserRepository.get(email, password)
       return if (user != null){

            mSecurityPreferences.storeString(TestContans.KEY.USER_ID, user.id.toString())
            mSecurityPreferences.storeString(TestContans.KEY.USER_NAME, user.name.toString())
            mSecurityPreferences.storeString(TestContans.KEY.USER_EMAIL, user.email.toString())
            mSecurityPreferences.storeString(TestContans.KEY.USER_TYPE, user.blood.toString())

            true

        }else{
              false}
    }

    fun insert(name: String, email: String, password: String, blood: String) {

        try {

            if (name == "" || email == "" || password == "" ) {

                throw ExeptionValidacion(context.getString(R.string.Preencha_todos_os_campos))

            }

            if (mUserRepository.isEmailExistent(email)){
                throw ExeptionValidacion(context.getString(R.string.Este_email_ja_existe_))
            }



                val userId = mUserRepository.insert(name, email, password, blood)
                //Salvar dados no shared
                mSecurityPreferences.storeString(TestContans.KEY.USER_ID, userId.toString())
                mSecurityPreferences.storeString(TestContans.KEY.USER_NAME, name.toString())
                mSecurityPreferences.storeString(TestContans.KEY.USER_EMAIL, email.toString())
                mSecurityPreferences.storeString(TestContans.KEY.USER_TYPE, blood.toString())



        } catch (e: Exception) {
            throw e
        }
    }

    fun getList(): MutableList<UserEntity> = mUserRepository.getList()

    }