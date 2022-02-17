package com.example.mangareader

class Manga(
    name: String,
    numberOfVolumes: String,
    mainTranslator: String,
    statusTranslation: String,
    statusReleaseManga: String,
    genres: String,
    category: String,
    screenwriters: String,
    painters: String,
    yearOfIssue: String,
    tags: String,
    mangaChapters: MutableList<MangaChapter>
) {
    var name: String = name  //Название манги
    var numberOfVolumes: String = numberOfVolumes //Количество томов
    var mainTranslator: String = mainTranslator //Основной переводчик
    var statusTranslation: String = statusTranslation //Статус перевода манги
    var statusReleaseManga: String = statusReleaseManga //Статус выхода манги
    var genres: String = genres //Жанры
    var category: String = category //Категория
    var screenwriters: String = screenwriters //Сценаристы
    var painters: String = painters //Художники
    var yearOfIssue: String = yearOfIssue //Год выпуска
    var tags: String = tags //Теги
    var mangaChapters: MutableList<MangaChapter> = mangaChapters

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