package com.example.wallpapers.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.wallpapers.databinding.FregmentFullScreenPictureBinding
import com.example.wallpapers.ui.viewmodel.WallpapersViewModel

class FullScreenPictureFragment : Fragment() {
    private val viewModel: WallpapersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FregmentFullScreenPictureBinding.inflate(inflater)
        binding.viewModel = viewModel

        return binding.root
    }
}