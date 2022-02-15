package com.example.mangareader


class Parser : Resource() {

    public fun pars() {
        val doc = getInfo("https://readmanga.io/podniatie_urovnia_v_odinochku__A56ff")

        print(doc)
    }

}