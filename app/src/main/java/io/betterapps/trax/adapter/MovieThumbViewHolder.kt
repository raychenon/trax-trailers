package io.betterapps.trax.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.betterapps.trax.R
import io.betterapps.trax.image.ImageLoader
import io.betterapps.trax.network.models.Movie
import kotlinx.android.extensions.LayoutContainer

class MovieThumbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {


    private val title: TextView = itemView.findViewById(R.id.textview_title)
    private val thumbnail: ImageView = itemView.findViewById(R.id.imageview_movie_thumb)

    init {
        Log.d("bindData", "Init created ")
    }

    // https://stackoverflow.com/questions/28364837/picasso-does-not-work-with-recycler-view-in-android
    override val containerView: View?
        get() = itemView

    fun bindData(item: Movie) {
        title.text = item.page.movie_title
        ImageLoader.load(thumbnail, item.thumbnail())
    }

}