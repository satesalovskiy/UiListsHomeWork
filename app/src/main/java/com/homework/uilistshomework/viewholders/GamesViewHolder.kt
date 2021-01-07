package com.homework.uilistshomework.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.homework.uilistshomework.Item
import com.homework.uilistshomework.databinding.ItemsGameBinding

class GamesViewHolder(private val binding: ItemsGameBinding) : BaseViewHolder(
    binding.root
) {
    constructor(parent: ViewGroup) : this(
        ItemsGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun bind(item: Item, removeCallback: ((item: Item) -> (Unit))?) {
        item as Item.Game
        binding.gameName.text = item.text
    }
}