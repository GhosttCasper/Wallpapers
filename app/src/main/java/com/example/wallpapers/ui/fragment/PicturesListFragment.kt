package com.example.wallpapers.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.wallpapers.R
import com.example.wallpapers.databinding.FragmentPicturesListBinding
import com.example.wallpapers.ui.adapter.PictureGridAdapter
import com.example.wallpapers.ui.adapter.PictureListener
import com.example.wallpapers.ui.viewmodel.WallpapersViewModel

class PicturesListFragment : Fragment() {

    private val viewModel: WallpapersViewModel by activityViewModels()

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPicturesListBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the photosGrid RecyclerView
        binding.photosGrid.adapter = PictureGridAdapter(PictureListener { picture ->
            viewModel.onPictureClicked(picture)
            findNavController().navigate(R.id.action_picturesListFragment_to_fullScreenPictureFragment)
        })

        return binding.root
    }
}