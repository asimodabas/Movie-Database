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
     //   val liste=Kategorilerdao().tumKategoriler(vt)

        val liste = Filmlerdao().tumFilmlerByKategoriId(vt,2)

        for (f in liste){
            Log.e("Film Id:",(f.film_id.toString()))
            Log.e("Film Adı:",(f.film_ad))
            Log.e("Film Yıl:",(f.film_yil.toString()))
            Log.e("Film Resim:",(f.film_resim))
            Log.e("Film Kategori Id:",(f.kategori.kategori_id.toString()))
            Log.e("Film Kategori Ad:",(f.kategori.kategori_ad))
            Log.e("Film Yonetmen Id:",(f.yonetmen.yonetmen_id.toString()))
            Log.e("Film Yonetmen Ad:",(f.yonetmen.yonetmen_ad))
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