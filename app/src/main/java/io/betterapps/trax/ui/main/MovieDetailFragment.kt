package io.betterapps.trax.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.betterapps.trax.R
import io.betterapps.trax.image.ImageLoader

class MovieDetailFragment : Fragment() {

    companion object {
        val ARGS_TITLE = "movie_title"
        val ARGS_DATE = "movie_release_date"
        val ARGS_IMAGE_URL = "movie_image_url"

        fun newInstance() = MovieDetailFragment()
    }

    private val TAG = this.javaClass.name
    private lateinit var textTitle: TextView
    private lateinit var textDate: TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            val view = inflater.inflate(R.layout.movie_detail_fragment, container, false)
            textTitle = view.findViewById(R.id.textview_detail_title)
            textDate = view.findViewById(R.id.textview_detail_release_date)
            imageView = view.findViewById(R.id.imageview_detail)
            return view
        } catch (e: Exception) {
            Log.e(TAG, "onCreateView ", e)
            throw e
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        textTitle.text = arguments?.getString(ARGS_TITLE, "Failed")
        textDate.text = arguments?.getString(ARGS_DATE)
        arguments?.getString(ARGS_IMAGE_URL)?.let {
            Log.d(TAG, "URL image view = ${it} ")
            ImageLoader.load(imageView, it)
        }
    }
}