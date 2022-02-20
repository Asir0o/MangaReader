package com.example.mangareader

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleName: TextView = findViewById(R.id.titleName)
        val titleImage: ImageView = findViewById(R.id.titleImage)
        val titleVolume: TextView = findViewById(R.id.titleVolume)
        val titleDescription: TextView = findViewById(R.id.titleDescription)
        val titleTranslator: TextView = findViewById(R.id.titleTranslator)
        val titleStatusTranslation: TextView = findViewById(R.id.titleStatusTranslation)
        val titleGenre: TextView = findViewById(R.id.titleGenre)
        val titleCategory: TextView = findViewById(R.id.titleCategory)
        val titleScreenwriters: TextView = findViewById(R.id.titleScreenwriters)
        val titlePainters: TextView = findViewById(R.id.titlePainters)
        val titleYearOfIssue: TextView = findViewById(R.id.titleYearOfIssue)
        val titleTags: TextView = findViewById(R.id.titleTags)
        val chaptersButton : Button = findViewById(R.id.chapters_button)
        val intent = Intent(this, MangaChaptersActivity::class.java)
        var manga: Manga? = null
        val thread = Thread {
            val parser = Parser()
            manga = parser.parsTitle();
        }
        thread.start()
        thread.join()
        if (manga != null) {
            titleName.text = manga!!.name
            setImage(titleImage, manga!!.titleImage)
            titleVolume.text = manga!!.numberOfVolumesAndStatus
            titleDescription.text = manga!!.description
            titleScreenwriters.text = manga!!.screenwriters
            titleTranslator.text = manga!!.mainTranslator
            titleStatusTranslation.text = manga!!.statusTranslation
            titleGenre.text = manga!!.genres
            titleCategory.text = manga!!.category
            titlePainters.text = manga!!.painters
            titleYearOfIssue.text = manga!!.yearOfIssue
            titleTags.text = manga!!.tags
            var titleBool: Boolean = false
            var descriptionBool: Boolean = false
            titleTags.setOnClickListener {
                titleBool = if (!titleBool) {
                    titleTags.maxLines = Integer.MAX_VALUE
                    true
                } else {
                    titleTags.maxLines = 1
                    false
                }
            }
            titleDescription.setOnClickListener {
                descriptionBool = if (!descriptionBool) {
                    titleDescription.maxLines = Integer.MAX_VALUE
                    true
                } else {
                    titleDescription.maxLines = 5
                    false
                }
            }
            chaptersButton.setOnClickListener {
                intent.putExtra(MangaChaptersActivity.TOTAL_COUNT, manga)
                startActivity(intent)
            }
        }
    }

    //метод загрузки изображения с помощью библиотеки Glide
    private fun setImage(image: ImageView, url: String): Boolean {
        Glide.with(this)
            .load(url)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_launcher_foreground)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: com.bumptech.glide.load.DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(image)
        return false
    }
}