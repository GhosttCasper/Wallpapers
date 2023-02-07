package com.example.wallpapers.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpapers.databinding.GridViewItemBinding
import com.example.wallpapers.network.WallpapersPicture

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class PictureGridAdapter(val clickListener: PictureListener) :
    ListAdapter<WallpapersPicture, PictureGridAdapter.PictureViewHolder>(DiffCallback) {

    /**
     * The PictureViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [WallpapersPicture] information.
     */
    class PictureViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: PictureListener, wallpapersPicture: WallpapersPicture) {
            binding.picture = wallpapersPicture
            binding.clickListener = clickListener
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [WallpapersPicture] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<WallpapersPicture>() {
        override fun areItemsTheSame(
            oldItem: WallpapersPicture,
            newItem: WallpapersPicture
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: WallpapersPicture,
            newItem: WallpapersPicture
        ): Boolean {
            return oldItem.webformatURL == newItem.webformatURL
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PictureViewHolder {
        return PictureViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val picture = getItem(position)
        holder.bind(clickListener, picture)
    }
}

class PictureListener(val clickListener: (picture: WallpapersPicture) -> Unit) {
    fun onClick(picture: WallpapersPicture) = clickListener(picture)
}