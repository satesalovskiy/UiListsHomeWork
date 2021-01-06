package com.homework.uilistshomework

import android.graphics.drawable.Drawable

sealed class Item {
    data class Film(val image: Drawable, val text: String) : Item()
    data class GameWithPreview(val image: Drawable, val text: String) : Item()
    data class Game(val text: String) : Item()
}
