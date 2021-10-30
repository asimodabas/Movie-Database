package com.asimodabas.movie_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()
    }

    fun veritabaniKopyala() {

        val db = DatabaseCopyHelper(this)

        try {
            db.createDataBase()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            db.openDataBase()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}