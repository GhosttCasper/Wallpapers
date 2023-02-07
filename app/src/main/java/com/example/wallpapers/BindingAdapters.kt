package com.example.wallpapers

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.wallpapers.network.WallpapersPicture
import com.example.wallpapers.ui.adapter.PictureGridAdapter
import com.example.wallpapers.ui.viewmodel.PictureApiStatus

/**
 * Uses the Coil library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

/**
 * Updates the data shown in the [RecyclerView].
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<WallpapersPicture>?) {
    val adapter = recyclerView.adapter as PictureGridAdapter
    adapter.submitList(data)
}

/**
 * This binding adapter displays the [PictureApiStatus] of the network request in an image view.  When
 * the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("PictureApiStatus")
fun bindStatus(statusImageView: ImageView, status: PictureApiStatus) {
    when (status) {
        PictureApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        PictureApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        PictureApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}