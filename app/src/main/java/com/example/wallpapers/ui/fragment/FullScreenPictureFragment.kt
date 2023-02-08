package com.example.wallpapers.ui.fragment

import android.app.WallpaperManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.databinding.FragmentFullScreenPictureBinding
import com.example.wallpapers.ui.viewmodel.WallpapersViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
import java.net.URL

class FullScreenPictureFragment : Fragment() {
    private val viewModel: WallpapersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        val binding = FragmentFullScreenPictureBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.setWallpaperButton.setOnClickListener { setWallpaper() }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    fun setWallpaper() {
        viewModel.viewModelScope.launch(Dispatchers.IO) {
            val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
            val ins: InputStream = URL(viewModel.picture.value!!.largeImageURL).openStream()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setStream(
                    ins, null, true,
                    WallpaperManager.FLAG_LOCK or WallpaperManager.FLAG_SYSTEM
                )
            } else
                wallpaperManager.setStream(ins)
        }
    }
}