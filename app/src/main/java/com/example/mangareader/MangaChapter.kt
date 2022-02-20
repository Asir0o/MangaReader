package com.example.mangareader

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaChapter(
    //Название тома и главы
    var nameOfChapter: String,
    //ссылка для чтения
    var ref: String
) : Parcelable
