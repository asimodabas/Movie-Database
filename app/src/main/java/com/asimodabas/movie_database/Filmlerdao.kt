package com.asimodabas.movie_database

import android.annotation.SuppressLint

class Filmlerdao {


    //SELECT * FROM filmler,kategoriler,yonetmenler WHERE filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=2

    @SuppressLint("Range")
    fun tumFilmlerByKategoriId(vt: DatabaseHelper, kategori_id: Int): ArrayList<Filmler> {

        val filmlerListe = ArrayList<Filmler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM filmler,kategoriler,yonetmenler WHERE filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_id",
            null
        )

        while (cursor.moveToNext()) {
            val kategori = Kategoriler(
                cursor.getInt(cursor.getColumnIndex("kategori_id")),
                cursor.getString(cursor.getColumnIndex("kategori_ad"))
            )

            val yonetmen = Yonetmenler(
                cursor.getInt(cursor.getColumnIndex("yonetmen_id")),
                cursor.getString(cursor.getColumnIndex("yonetmen_ad"))
            )

            val film = Filmler(
                cursor.getInt(cursor.getColumnIndex("film_id")),
                cursor.getString(cursor.getColumnIndex("kategori_ad")),
                cursor.getInt(cursor.getColumnIndex("kategori_yil")),
                cursor.getString(cursor.getColumnIndex("kategori_resim")), kategori, yonetmen
            )

            filmlerListe.add(film)

        }

        return filmlerListe

    }

}