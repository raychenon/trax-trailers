package io.betterapps.trax.adapter

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.betterapps.trax.R
import io.betterapps.trax.image.ImageLoader
import io.betterapps.trax.network.models.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_grid_item.view.*

class MovieThumbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    init {
        Log.d("bindData", "Init created ")
    }

    override val containerView: View?
        get() = itemView

    fun bindData(item: Movie,  listener: (Movie) -> Unit) {
        with(itemView) {
            textview_title.text = item.page.movie_title
            ImageLoader.load(imageview_movie_thumb, item.thumbnail())
            imageview_movie_thumb.setOnClickListener {
                listener(item)
            }
        }
    }

}