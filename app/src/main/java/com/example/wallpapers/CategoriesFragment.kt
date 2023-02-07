package com.example.wallpapers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.wallpapers.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private val viewModel: WallpapersViewModel by activityViewModels()

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoriesBinding.inflate(inflater)
        with(binding)
        {
            categoryFeelingsButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_feelings))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
            categoryEducationButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_education))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
            categoryHealthButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_health))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
            categoryNatureButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_nature))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
            categoryScienceButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_science))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
            categoryTravelButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_travel))
                findNavController().navigate(R.id.action_categoriesFragment_to_picturesListFragment)
            }
        }

        return binding.root
    }
}
