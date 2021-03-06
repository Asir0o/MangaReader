package com.example.mangareader
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

abstract class Resource {

    public fun getInfo(link: String): Document {
        return Jsoup.connect(link).get()
    }
}