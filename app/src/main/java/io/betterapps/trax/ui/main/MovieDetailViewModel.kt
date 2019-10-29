package io.betterapps.trax.ui.main

import androidx.lifecycle.ViewModel
import io.betterapps.trax.network.models.Movie

class MovieDetailViewModel(
    private val movieId: String,
    private val movie: Movie
) : ViewModel() {
}