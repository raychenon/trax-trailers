package io.betterapps.trax.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.betterapps.trax.R
import io.betterapps.trax.adapter.MovieAdapter
import io.betterapps.trax.network.models.Movie
import io.betterapps.trax.network.models.MovieResponse

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerview_movies)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setupGrid()

        request()
    }

    private fun setupGrid() {
        movieAdapter = MovieAdapter(emptyList(), { movie: Movie -> navigateToMovie(movie) })
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 3)
            adapter = movieAdapter
        }

    }

    private fun request(): Unit {
        viewModel.getMoviesResponse().observe(this, Observer { it ->
            handleResponse(it)
        })
    }

    private fun handleResponse(response: MovieResponse) {
        if (response.hasError) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        } else {
            response?.movies?.let { updateUIAfterResponse(it) }
        }
    }

    private fun updateUIAfterResponse(data: List<Movie>) {
        movieAdapter.data = data
        movieAdapter.notifyDataSetChanged()
    }

    private fun navigateToMovie(movie: Movie) {
        val bundle = bundleOf("movie" to "test")
        this.view?.findNavController()?.navigate(R.id.movie_detail_fragment, bundle)
    }
}
