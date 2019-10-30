package io.betterapps.trax.ui.main

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import io.betterapps.trax.R
import io.betterapps.trax.image.ImageLoader


class MovieDetailFragment : Fragment() {

    companion object {
        val ARGS_TITLE = "movie_title"
        val ARGS_DATE = "movie_release_date"
        val ARGS_IMAGE_URL = "movie_image_url"
        val ARGS_MOVIE_URL = "movie_trailer_url"

        fun newInstance() = MovieDetailFragment()
    }

    private val TAG = this.javaClass.name
    private lateinit var textTitle: TextView
    private lateinit var textDate: TextView
    private lateinit var imageView: ImageView
    private lateinit var playerView: PlayerView

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
            playerView = view.findViewById(io.betterapps.trax.R.id.player_view)
            return view
        } catch (e: Exception) {
            Log.e(TAG, "onCreateView ", e)
            throw e
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        textTitle.text = arguments?.getString(ARGS_TITLE)
        textDate.text = arguments?.getString(ARGS_DATE)
        arguments?.getString(ARGS_IMAGE_URL)?.let {
            ImageLoader.load(imageView, it)
        }

        initVideo(Uri.parse(arguments?.getString(ARGS_MOVIE_URL)))
    }

    private fun initVideo(mp4VideoUri: Uri): Unit {

        val player = ExoPlayerFactory.newSimpleInstance(context)


        // Produces DataSource instances through which media data is loaded.
        val dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "yourApplicationName")
        )
        // This is the MediaSource representing the media to be played.

        val videoSource =
            ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(mp4VideoUri)
        // Prepare the player with the source.
        player.prepare(videoSource)


        playerView.setPlayer(player)
    }

}