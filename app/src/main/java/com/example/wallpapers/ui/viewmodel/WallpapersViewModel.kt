package com.example.wallpapers.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.network.WallpapersApi
import com.example.wallpapers.network.WallpapersPicture
import kotlinx.coroutines.launch

private const val TAG_ERROR = "MyError"

enum class PictureApiStatus { LOADING, ERROR, DONE }

class WallpapersViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<PictureApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<PictureApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of WallpapersPicture
    // with new values
    private val _pictures = MutableLiveData<List<WallpapersPicture>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val pictures: LiveData<List<WallpapersPicture>> = _pictures

    //  Create properties to represent MutableLiveData and LiveData for a single Picture object.
    //  This will be used to display the full-screen picture when a list item is clicked
    private val _picture = MutableLiveData<WallpapersPicture>()
    val picture: LiveData<WallpapersPicture> = _picture

    /**
     * Gets pictures information from the API Retrofit service and updates the
     * [WallpapersPicture] [List] [LiveData].
     */
    fun getWallpapersPictures(category: String) {
        viewModelScope.launch {
            _status.value = PictureApiStatus.LOADING
            try {
                _pictures.value = WallpapersApi.retrofitService.getPictures(category).hits
                _status.value = PictureApiStatus.DONE
            } catch (e: Exception) {
                _status.value = PictureApiStatus.ERROR
                _pictures.value = listOf()
                Log.e(TAG_ERROR, e.toString())
            }
        }
    }

    fun onPictureClicked(picture: WallpapersPicture) {
        // Set the picture object
        _picture.value = picture
    }
}