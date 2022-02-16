package com.example.mangareader

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

open class Resource {

    fun getInfo(link: String): Document {
        return Jsoup.connect(link).get()
    }
}