package com.example.mangareader

import java.io.FileDescriptor

class Manga(
    name: String,
    numberOfVolumesAndStatus: String,
    mainTranslator: String,
    statusTranslation: String,
    genres: String,
    category: String,
    screenwriters: String,
    painters: String,
    yearOfIssue: String,
    tags: String,
    titleImage: String,
    mangaChapters: MutableList<MangaChapter>,
    description:String
) {
    var name: String = name  //Название манги
    var numberOfVolumesAndStatus: String =
        numberOfVolumesAndStatus //Количество томов и статус выхода манги
    var mainTranslator: String = mainTranslator //Основной переводчик
    var statusTranslation: String = statusTranslation //Статус перевода манги
    var genres: String = genres //Жанры
    var category: String = category //Категория
    var screenwriters: String = screenwriters //Сценаристы
    var painters: String = painters //Художники
    var yearOfIssue: String = yearOfIssue //Год выпуска
    var tags: String = tags //Теги
    var titleImage: String = titleImage //url на картинку манги
    var mangaChapters: MutableList<MangaChapter> = mangaChapters // главы и тома манги
    var description:String = description


    //    class Manga constructor(
//        name: String,
//        numberOfVolumes: Int,
//        mainTranslator: String,
//        statusTranslation: String,
//        statusManga: String,
//        genres: String,
//        category: String,
//        screenwriters: String,
//        painters: String,
//        yearOfIssue: String,
//        tags: String
//    ) {
//
//            name = name
//
//    }


}