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

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ListOfChaptersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MangaChaptersAdapter()

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}