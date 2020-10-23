package ru.dernogard.simplepartyscreen.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.dernogard.simplepartyscreen.R

/**
 * This class helps avoid code duplication.
 * We can use just functions in the file without object, but I more like when they in classes
 * It's more clearly and informatively in the code
 */

object ImageHelper {

    /**
     * The function takes image's source and shows image using library Glide
     * @param src: link to file in the Internet
     */
    fun loadPartyLogo(imageView: ImageView, src: String) {
        Glide.with(imageView.context)
            .load(src)
            .placeholder(R.drawable.waiting)
            .error(R.drawable.not_found_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(imageView)
    }

    /**
     * The function takes image's source and shows image using library Glide
     * @param src: link to file in the Internet
     */
    fun loadUserPhoto(imageView: ImageView, src: String) {
        Glide.with(imageView.context)
            .load(src)
            .placeholder(R.drawable.empty_photo)
            .error(R.drawable.empty_photo)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .circleCrop()
            .into(imageView)
    }
}