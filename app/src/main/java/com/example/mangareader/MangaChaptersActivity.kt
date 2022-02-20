package com.example.mangareader

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangareader.databinding.ActivityMainBinding
import com.example.mangareader.databinding.ListOfChaptersActivityBinding

class MangaChaptersActivity : AppCompatActivity() {
    private lateinit var binding: ListOfChaptersActivityBinding
    private lateinit var adapter: MangaChaptersAdapter

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ListOfChaptersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manga = intent.getParcelableExtra<Manga>(TOTAL_COUNT)

        adapter = MangaChaptersAdapter(manga)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}