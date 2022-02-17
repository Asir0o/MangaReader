package com.example.mangareader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val titleName:TextView =  findViewById(R.id.titleName)
        val titleImage: ImageView =  findViewById(R.id.titleImage)
        val titleVolume:TextView =  findViewById(R.id.titleVolume)
        val titleDescription:TextView =  findViewById(R.id.titleDescription)
        val titleTranslator:TextView =  findViewById(R.id.titleTranslator)
        val titleStatusTranslation:TextView =  findViewById(R.id.titleStatusTranslation)
        val titleStatusRelease:TextView =  findViewById(R.id.titleStatusRelease)
        val titleGenre:TextView =  findViewById(R.id.titleGenre)
        val titleCategory:TextView =  findViewById(R.id.titleScreenwriters)
        val titlePainters:TextView =  findViewById(R.id.titlePainters)
        val titleYearOfIssue:TextView =  findViewById(R.id.titleYearOfIssue)
        val titleTags:TextView =  findViewById(R.id.titleTags)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thread = Thread {
            val parser = Parser()
            parser.parsTitle()
            
        }
        thread.start()
    }

}