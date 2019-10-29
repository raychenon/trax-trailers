package io.betterapps.trax.image

import android.widget.ImageView
import com.squareup.picasso.Picasso
import io.betterapps.trax.R

/**
 * Facade to any image libraries (Picasso, Fresco, Glide), so it is easier to change to another library.
 */
object ImageLoader {

    fun load(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.loading)
            .error(R.drawable.ic_launcher_round)
            .fit()
            .into(imageView)
    }
}