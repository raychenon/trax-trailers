package io.betterapps.trax.image

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {

    fun load(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .fit()
            .into(imageView)
    }
}