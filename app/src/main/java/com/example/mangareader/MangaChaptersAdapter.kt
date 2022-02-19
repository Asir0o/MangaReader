package com.example.mangareader

import android.os.Binder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareader.databinding.ItemChapterBinding

class MangaChaptersAdapter(var manga : Manga) : RecyclerView.Adapter<MangaChaptersAdapter.MangaChaptersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaChaptersViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemChapterBinding = ItemChapterBinding.inflate(inflater, parent, false)
        return MangaChaptersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangaChaptersViewHolder, position: Int) {
        val chapter : MangaChapter = manga.mangaChapters[position]
        with(holder.binding) {
            chaptersNameTextView.text = chapter.nameOfChapter
        }
    }

    override fun getItemCount(): Int = manga.mangaChapters.size

    class MangaChaptersViewHolder(
        val binding: ItemChapterBinding
    ) : RecyclerView.ViewHolder(binding.root)
}