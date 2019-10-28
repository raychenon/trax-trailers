package io.betterapps.trax.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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

        // request after creation
        request()
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
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 3)
            adapter = MovieAdapter(data)
        }
    }


}
