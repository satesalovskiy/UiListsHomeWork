package com.homework.uilistshomework

import android.content.Context
import android.graphics.drawable.Drawable

object DataUtils {

    @ExperimentalStdlibApi
    fun getFirstTypeData(context: Context): List<Item.Film> {

        val nameToPreview = getNamesFromResources(R.array.films_list, context).zip(
            getPreviews(
                "images/films",
                "film_preview_",
                context
            ).toTypedArray()
        ).toMap()

        return buildList(nameToPreview.size) {
            nameToPreview.forEach { (name, drawable) ->
                add(Item.Film(drawable, name))
            }
        }
    }

    @ExperimentalStdlibApi
    fun getSecondTypeData(context: Context): List<Item.GameWithPreview> {

        val nameToPreview = getNamesFromResources(
            R.array.games_with_preview_list,
            context
        ).zip(getPreviews("images/games", "game_preview_", context).toTypedArray()).toMap()

        return buildList(nameToPreview.size) {
            nameToPreview.forEach { (name, drawable) ->
                add(Item.GameWithPreview(drawable, name))
            }
        }
    }

    @ExperimentalStdlibApi
    fun getThirdTypeData(context: Context): List<Item.Game> {
        val names = getNamesFromResources(R.array.games_list, context)
        return buildList(names.size) {
            names.forEach {
                add(Item.Game(it))
            }
        }
    }

    private fun getNamesFromResources(resId: Int, context: Context): List<String> =
        context.resources.getStringArray(resId).toList()

    private fun getPreviews(path: String, filter: String, context: Context): List<Drawable> {
        val names = context.assets.list(path)?.toList()?.filter { it.contains(filter) }
        val images = mutableListOf<Drawable>()
        names?.forEach {
            val inputStream = context.assets.open(
                path
                        + "/"
                        + it
            )
            images.add(Drawable.createFromStream(inputStream, null))
        }
        return images
    }
}