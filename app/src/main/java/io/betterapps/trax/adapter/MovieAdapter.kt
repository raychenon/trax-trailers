package io.betterapps.trax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.betterapps.trax.R
import io.betterapps.trax.network.models.Movie

class MovieAdapter(var data: List<Movie>, private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieThumbViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieThumbViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_grid_item, parent, false)
            .let { MovieThumbViewHolder(it) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MovieThumbViewHolder, position: Int) {
        holder.apply {
            bindData(data.get(position),listener)
        }
    }

}