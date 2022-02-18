package com.example.mangareader

import android.media.Image
import android.util.Log
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


class Parser : Resource() {

    public fun parsTitle(): Manga {
        val doc = getInfo("https://readmanga.io/podniatie_urovnia_v_odinochku__A56ff")
        val name: String = doc.select("span.name").text()
        val description: String = doc.select("div.manga-description").text()
        val statusTranslation: String = doc.select("div.subject-meta p:eq(3)").text()
        val mainTranslator: String = doc.select("div.subject-meta p:eq(2)").text()
        val numberOfVolumesAndStatus: String = doc.select("div.subject-meta p:eq(1)").text()
        var genres: String = ""
        val titleImage: String = doc.select("div.expandable img:eq(0)").attr("src")
        val category: String = doc.select("div.subject-meta p:eq(5)").text()
        var screenwriters: String = ""
        var painters: String = ""
        val yearOfIssue = doc.select(".elem_year > .element-link").text()
        var tags: String = ""
        val mangaChapters = mutableListOf<MangaChapter>()
        Log.i("I", titleImage)
        Log.i("I", yearOfIssue)

        for (element: Element in doc.select("p.elementList > .elem_screenwriter")) {
            screenwriters += element.select(".person-link").text() + ", "
        }
        screenwriters = screenwriters.substring(0, screenwriters.length - 2)
        Log.i("I", screenwriters)

        for (element: Element in doc.select("p.elementList > .elem_illustrator")) {
            painters += element.select(".person-link").text() + ", "
        }
        painters = painters.substring(0, painters.length - 2)
        Log.i("I", painters)

        for (element: Element in doc.select("p.elementList > .elem_genre")) {
            genres += element.select(".element-link").text() + ", "
        }
        genres = genres.substring(0, genres.length - 2)
        Log.i("I", genres)

        for (element: Element in doc.select("p.elementList > .elem_tag")) {
            tags += element.select(".element-link").text() + ", "
        }
        tags = tags.substring(0, tags.length - 2)
        Log.i("I", tags)

        for (row: Element in doc.select("table.table.table-hover tr")) {
            mangaChapters.add(
                MangaChapter(
                    row.select("td.item-title").text(),
                    "https://readmanga.io" + row.select("a").attr("href")
                )
            )
        }
        Log.i("Name", name)
        Log.i("Description", description)

        return Manga(
            name,
            numberOfVolumesAndStatus,
            mainTranslator,
            statusTranslation,
            genres,
            category,
            screenwriters,
            painters,
            yearOfIssue,
            tags,
            titleImage,
            mangaChapters,
            description
        )

//        Log.i("Title", doc.title())
//        val headlines: Elements = doc.select("div.leftContent")
//        for (element : Element in doc.select("div.leftContent")) {
//            Log.i("Name", element.select("span.name").text())
//            name = element.select("span.name").text()
//        }


//        for (headline in newsHeadlines) {
//            Log.i(
//                "Head",
//                "${headline.attr("title")}\n\t${headline.absUrl("href")}"
//            )
//        }
    }
}