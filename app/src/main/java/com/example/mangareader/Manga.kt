package com.example.mangareader

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga (
    //Название манги
    var name: String,
    //Количество томов и статус выхода манги
    var numberOfVolumesAndStatus: String,
    //Основной переводчик
    var mainTranslator: String,
    //Статус перевода манги
    var statusTranslation: String,
    //Жанры
    var genres: String,
    //Категория
    var category: String,
    //Сценаристы
    var screenwriters: String,
    //Художники
    var painters: String,
    //Год выпуска
    var yearOfIssue: String,
    //Теги
    var tags: String,
    //url на картинку манги
    var titleImage: String,
    // главы и тома манги
    var mangaChapters: MutableList<MangaChapter>,
    //Описание манги
    var description: String
) : Parcelable