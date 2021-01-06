package com.homework.uilistshomework.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.ItemsGameWithPreviewBinding

class GamesWithPreviewViewHolder(private val binding: ItemsGameWithPreviewBinding) : BaseViewHolder(
    binding.root
) {
    constructor(parent: ViewGroup) : this(
        ItemsGameWithPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun bind(item: Item) {
        item as Item.GameWithPreview
        binding.gameName.text = item.text
        binding.gamePreview.background = item.image
    }
}