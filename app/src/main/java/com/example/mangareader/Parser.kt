package com.example.mangareader

import android.util.Log
import org.jsoup.nodes.Element
import org.jsoup.select.Elements


class Parser : Resource() {

    public fun parsTitle() {
        val doc = getInfo("https://readmanga.io/podniatie_urovnia_v_odinochku__A56ff")
        var name : String = doc.select("span.name").text()
        var description : String = doc.select("div.manga-description").text()
        var translate : String = doc.select("div.subject-meta p:eq(3)").text()
        var transletor : String = doc.select("div.subject-meta p:eq(2)").text()
        var volume : String = doc.select("div.subject-meta p:eq(1)").attr("#text")

        val genres = mutableListOf<String>()

        var i = 0
        for (element : Element in doc.select("p.elementList > .elem_genre")) {
            genres.add(element.select(".element-link").text())
            Log.i("I",genres[i])
            i++
        }

        for (row : Element in doc.select("table.table.table-hover tr")) {
            MangaChapter(row.select("td.item-title").text(),
                "https://readmanga.io" + row.select("a").attr("href"))
        }

//        Manga(name,)

        Log.i("Name", name)
        Log.i("Description", description)
        Log.i("I", translate)
        Log.i("I", volume)



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