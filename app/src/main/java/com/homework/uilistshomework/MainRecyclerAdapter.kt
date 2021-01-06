package com.homework.uilistshomework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.viewholders.BaseViewHolder
import com.homework.uilistshomework.viewholders.FilmsViewHolder
import com.homework.uilistshomework.viewholders.GamesWithPreviewViewHolder
import com.homework.uilistshomework.viewholders.GamesViewHolder

class MainRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var list: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FIRST_TYPE -> FilmsViewHolder(parent)
            SECOND_TYPE -> GamesWithPreviewViewHolder(parent)
            else -> GamesViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = list[position]) {
            is Item.Film -> (holder as FilmsViewHolder).bind(item)
            is Item.GameWithPreview -> (holder as GamesWithPreviewViewHolder).bind(item)
            is Item.Game -> (holder as GamesViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Item.Film -> FIRST_TYPE
            is Item.GameWithPreview -> SECOND_TYPE
            is Item.Game -> THIRD_TYPE
        }
    }

    companion object {
        const val FIRST_TYPE = 1
        const val SECOND_TYPE = 2
        const val THIRD_TYPE = 3
    }
}