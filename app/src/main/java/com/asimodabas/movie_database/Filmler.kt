package com.asimodabas.movie_database

data class Filmler(
    var film_id: Int,
    var film_ad: String,
    var film_yil: Int,
    var film_resim: String,
    var kategori: Kategoriler,
    var yonetmen: Yonetmenler
) {
}