package com.asimodabas.movie_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        val vt=DatabaseHelper(this)
        val liste=Kategorilerdao().tumKategoriler(vt)

        for (k in liste){
            Log.e("Kategori Adı:",k.kategori_ad)
            Log.e("Kategori Id:",k.kategori_id.toString())
        }
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