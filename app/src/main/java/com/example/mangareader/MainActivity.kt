package com.example.mangareader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val testText: TextView = findViewById(R.id.testText)
        val thread = Thread {
            val parser = Parser()

            parser.parsTitle()
        }
        thread.start()
    }
}