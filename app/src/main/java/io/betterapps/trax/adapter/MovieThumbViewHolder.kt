package io.betterapps.trax.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.betterapps.trax.image.ImageLoader
import io.betterapps.trax.network.models.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.movie_grid_item.view.*

class MovieThumbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bindData(item: Movie) {
        itemView.textview_title.text = item.page.movie_title

        ImageLoader.load(itemView.imageview_movie_thumb,item.thumbnail())
    }

}