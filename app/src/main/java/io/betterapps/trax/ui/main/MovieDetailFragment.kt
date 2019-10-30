package io.betterapps.trax.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.betterapps.trax.R

class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private lateinit var textTitle: TextView
    private lateinit var textDate: TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.movie_detail_fragment, container, false)
        textTitle = view.findViewById(R.id.textview_detail_title)
        textDate = view.findViewById(R.id.textview_detail_release_date)
        imageView = view.findViewById(R.id.imageview_detail)
        return view
    }
}