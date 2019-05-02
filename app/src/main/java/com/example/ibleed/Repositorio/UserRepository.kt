package com.example.ibleed.Repositorio

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.ibleed.Constantes.DataBaseConstantes
import com.example.ibleed.Entidades.UserEntity
import java.lang.Exception

class UserRepository private constructor(context: Context){

    private var mBloodDataBase : BloodDataBase = BloodDataBase(context)


    companion object {
        fun getInstance(context: Context): UserRepository{
            if (INSTANCE == null){

            INSTANCE = UserRepository(context)
            }
             return INSTANCE as UserRepository
        }


    private var INSTANCE: UserRepository? = null
     }

// função do login
    fun get (email: String, password: String): UserEntity?{
        var userEntity: UserEntity? = null
try {
    val cursor: Cursor
    val db = mBloodDataBase.readableDatabase

    val projection = arrayOf(DataBaseConstantes.USER.COLUMS.ID,
                                          DataBaseConstantes.USER.COLUMS.EMAIL,
                                          DataBaseConstantes.USER.COLUMS.NAME,
                                          DataBaseConstantes.USER.COLUMS.PASS,
                                          DataBaseConstantes.USER.COLUMS.TYPE)


    val selection = "${DataBaseConstantes.USER.COLUMS.EMAIL} = ? AND ${DataBaseConstantes.USER.COLUMS.PASS} = ?"
    val selectionArgs = arrayOf(email, password)
    cursor =
        db.query(DataBaseConstantes.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null, null)
    if (cursor.count > 0){

        cursor.moveToFirst()

       val userId=  cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.ID))
        val name=  cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.NAME))
        val email=  cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.EMAIL))
        val blood=  cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.TYPE))

             userEntity = UserEntity(userId, name, email, blood)
    }
    cursor.close()
}
catch (e: Exception){
    return userEntity
     }
return userEntity
    }

    //Verifica se email ja existe
    fun isEmailExistent(email: String): Boolean {
        var ret: Boolean = false
        try {

            val cursor: Cursor
            val db = mBloodDataBase.readableDatabase

            val projection = arrayOf(DataBaseConstantes.USER.COLUMS.ID)

            val selection = "${DataBaseConstantes.USER.COLUMS.EMAIL} = ?"
            val selectionArgs = arrayOf(email)
            cursor =
                db.query(DataBaseConstantes.USER.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
            ret = cursor.count > 0
            cursor.close()

        } catch (e: Exception) {
            throw e
        }
        return ret
    }


    fun insert(name: String, email: String, password: String, blood: String): Int {

        val db = mBloodDataBase.writableDatabase

        val insertValues = ContentValues()

        insertValues.put(DataBaseConstantes.USER.COLUMS.NAME, name)
        insertValues.put(DataBaseConstantes.USER.COLUMS.EMAIL, email)
        insertValues.put(DataBaseConstantes.USER.COLUMS.PASS, password)
        insertValues.put(DataBaseConstantes.USER.COLUMS.TYPE, blood)


        return db.insert(DataBaseConstantes.USER.TABLE_NAME, null, insertValues).toInt()
    }

    fun getList(): MutableList<UserEntity>{

        val list= mutableListOf<UserEntity>()

        try {


            val cursor: Cursor
            val db = mBloodDataBase.readableDatabase

            cursor = db.rawQuery("SELECT * FROM ${DataBaseConstantes.USER.TABLE_NAME}", null)
            if (cursor.count > 0){

                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.NAME))
                    val email = cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.EMAIL))
                    val blood = cursor.getString(cursor.getColumnIndex(DataBaseConstantes.USER.COLUMS.TYPE))

                    list.add(UserEntity(id, name,email,blood))

                }

            }
            cursor.close()

        }catch (e: Exception){
            return list
        }
        return list
    }


}