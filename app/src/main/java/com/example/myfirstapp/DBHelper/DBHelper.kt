package com.example.myfirstapp.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myfirstapp.Model.Person

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME, factory: null,DATABASE_VER)  {
    companion object  {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "EDMTDB.db"

        //table
        private val TABLE_NAME="Person"
        private val COL_ID="Id"
        private val COL_NOM="Nom"
        private val COL_PRENOM="Prenom"
        private val COL_ADRESSE="Adresse"
        private val COL_MAIL="Mail"
        private val COL_NUMERO="Numero"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY : String = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY,$COL_NOM TEXT,$COL_PRENOM TEXT,$COL_ADRESSE TEXT,$COL_MAIL TEXT,$COL_NUMERO TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db.execSQL( sql: "DROP TABLE IF EXISTS $TABLE_NAME")
    }

    //CRUD
    val allPerson:list<Person>
        get(){
            val lstPerson = ArrayList<Person>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase! = this.writableDatabase
            val cursor: Cursor! = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val person = Person()
                    person.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    person.nom = cursor.getString(cursor.getColumnIndex(COL_NOM))
                    person.prenom = cursor.getString(cursor.getColumnIndex(COL_PRENOM))
                    person.adresse = cursor.getString(cursor.getColumnIndex(COL_ADRESSE))
                    person.mail = cursor.getString(cursor.getColumnIndex(COL_MAIL))
                    person.numero = cursor.getString(cursor.getColumnIndex(COL_NUMERO))

                    lstPerson(cursor.moveToNext())
                } while (cursor.moveToNext())
            }
            db.close()
            return lstPersons
        }

    fun addPerson (person: Person)
    {
        val db:SQLiteDatabase! = this.writableDatabase
        val values = contentValues()
        values.put(COL_ID,person.id)
        values.put(COL_NOM,person.nom)
        values.put(COL_PRENOM,person.prenom)
        values.put(COL_ADRESSE,person.adresse)
        values.put(COL_MAIL,person.mail)
        values.put(COL_NUMERO,person.numero)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun updatePerson (person: Person):Int
    {
        val db:SQLiteDatabase! = this.writableDatabase
        val values = contentValues()
        values.put(COL_ID,person.id)
        values.put(COL_NOM,person.nom)
        values.put(COL_PRENOM,person.prenom)
        values.put(COL_ADRESSE,person.adresse)
        values.put(COL_MAIL,person.mail)
        values.put(COL_NUMERO,person.numero)

        return db.update(TABLE_NAME, values, "$COL_ID=?", arrayOf(person.id.toString()))
    }

    fun deletePerson (person: Person)
    {
        val db:SQLiteDatabase! = this.writableDatabase

        db.delete(TABLE_NAME,"$COL_ID=?", arrayOF(person.id.toString()))
        db.close()
    }

}



