package com.homework.uilistshomework.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.Item

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Item, removeCallback: ((item: Item) -> (Unit))?)
}
