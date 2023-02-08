package com.example.wallpapers.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.wallpapers.R
import com.example.wallpapers.databinding.FragmentCategoriesBinding
import com.example.wallpapers.ui.viewmodel.WallpapersViewModel
import java.util.*

class CategoriesFragment : Fragment() {

    private val viewModel: WallpapersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoriesBinding.inflate(inflater)
        with(binding)
        {
            categoryFeelingsButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_feelings))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_feelings).replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        })
                findNavController().navigate(action)
            }
            categoryEducationButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_education))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_education)
                    )
                findNavController().navigate(action)
            }
            categoryHealthButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_health))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_health).replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        }
                    )
                findNavController().navigate(action)
            }
            categoryNatureButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_nature))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_nature).replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        }
                    )
                findNavController().navigate(action)
            }
            categoryScienceButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_science))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_science).replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        }
                    )
                findNavController().navigate(action)
            }
            categoryTravelButton.setOnClickListener {
                viewModel.getWallpapersPictures(getString(R.string.category_travel))
                val action =
                    CategoriesFragmentDirections.actionCategoriesFragmentToPicturesListFragment(
                        getString(R.string.category_travel).replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        }
                    )
                findNavController().navigate(action)
            }
        }

        return binding.root
    }
}
