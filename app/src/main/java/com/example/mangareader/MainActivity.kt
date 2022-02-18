package com.example.mangareader

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        var manga: Manga? = null
        val thread = Thread {
            val parser = Parser()
            manga = parser.parsTitle();

        }
        thread.start()
        thread.join()
        if (manga != null) {
            titleName.setText(manga!!.name)
            setImage(titleImage, manga!!.titleImage)
            titleVolume.setText(manga!!.numberOfVolumesAndStatus)
            titleDescription.setText(manga!!.description)
            titleScreenwriters.setText(manga!!.screenwriters)
            titleTranslator.setText(manga!!.mainTranslator)
            titleStatusTranslation.setText(manga!!.statusTranslation)
            titleGenre.setText(manga!!.genres)
            titleCategory.setText(manga!!.category)
            titlePainters.setText(manga!!.painters)
            titleYearOfIssue.setText(manga!!.yearOfIssue)
            titleTags.setText(manga!!.tags)
            var titleBool: Boolean = false
            var descriptionBool: Boolean = false
            titleTags.setOnClickListener({ v1 ->
                if (!titleBool) {
                    titleTags.setMaxLines(Integer.MAX_VALUE)
                    titleBool = true
                } else {
                    titleTags.setMaxLines(1)
                    titleBool = false
                }
            })
            titleDescription.setOnClickListener ({ v2 ->
                if (!descriptionBool) {
                    titleDescription.setMaxLines(Integer.MAX_VALUE)
                    descriptionBool = true
                } else {
                    titleDescription.setMaxLines(1)
                    descriptionBool = false
                }
            })
        }
    }
    //метод загрузки изображения с помощью библиотеки Glide
    private fun setImage(image:ImageView,url:String): Boolean {
        Glide.with(this)
            .load(url)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_launcher_foreground)
            .listener(object: RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean{
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