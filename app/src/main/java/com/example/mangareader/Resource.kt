package com.example.mangareader
import android.os.AsyncTask
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

abstract class Resource: AsyncTask<String, Void, RSSFeed> {

    public fun getInfo(link: String): Document {
        return Jsoup.connect(link).get()
    }
}