package com.example.ibleed.Repositorio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ibleed.Constantes.DataBaseConstantes

class BloodDataBase(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {
        private val DATABASE_VERSION: Int = 1
        private val DATABASE_NAME: String = "iBleed.db"
    }

    //SQL
    private val createTableUser = """ CREATE TABLE ${DataBaseConstantes.USER.TABLE_NAME}(
        ${DataBaseConstantes.USER.COLUMS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${DataBaseConstantes.USER.COLUMS.NAME} TEXT,
        ${DataBaseConstantes.USER.COLUMS.EMAIL} TEXT,
        ${DataBaseConstantes.USER.COLUMS.PASS} TEXT,
        ${DataBaseConstantes.USER.COLUMS.TYPE} TEXT
           ); """
/*
    private val createTablePriority = """ CREATE TABLE ${DataBaseConstantes.PRIORITY.TABLE_NAME}(
        ${DataBaseConstantes.PRIORITY.COLUMS.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
         ${DataBaseConstantes.PRIORITY.COLUMS.TYPE} TEXT

           ); """*/
//private val insertPriority = """INSERT INTO ${DataBaseConstantes.PRIORITY.TABLE_NAME} VALUES(1, 'Baixa')"  """

    private val deleteTableUser = " drop table if exists ${DataBaseConstantes.USER.TABLE_NAME}"

    override fun onCreate(sqlLite: SQLiteDatabase) {
           sqlLite.execSQL(createTableUser)
        //sqlLite.execSQL(createTablePriority)
    }

    override fun onUpgrade(sqlLite: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//remove
        sqlLite.execSQL(deleteTableUser)

        //cria
        sqlLite.execSQL(createTableUser)

    }


}


