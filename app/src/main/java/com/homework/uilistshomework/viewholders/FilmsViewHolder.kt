package com.homework.uilistshomework.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.ItemsFilmBinding

class FilmsViewHolder(private val binding: ItemsFilmBinding) :
    BaseViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun bind(item: Item) {
        item as Item.Film
        binding.filmName.text = item.text
        binding.filmPreview.background = item.image
    }
}