package com.example.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView

data class contacts(val nom: String, val prenom: String, val adresse: String, val mail: String,val numero: String)

class DisplayMessageActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        val message = intent.getStringExtra(EXTRA_MESSAGE)

    }
    fun saveContact (view: View){
        editText = findViewById<View>(R.id.nom) as EditText
        val nom = editText.text.toString()
        editText = findViewById<View>(R.id.prenom) as EditText
        val prenom = editText.text.toString()
        editText = findViewById<View>(R.id.adresse) as EditText
        val adresse = editText.text.toString()
        editText = findViewById<View>(R.id.mail) as EditText
        val mail = editText.text.toString()
        editText = findViewById<View>(R.id.numero) as EditText
        val numero = editText.text.toString()
        val test = contacts(nom, prenom, adresse, mail, numero)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

