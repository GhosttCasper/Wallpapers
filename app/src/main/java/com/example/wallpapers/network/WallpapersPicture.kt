package com.example.wallpapers.network

/**
 * This data class defines a Picture which includes an ID, and the image URL.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class WallpapersPicture(
    val id: String,
    val webformatURL: String
)

data class Hits(
    val hits: List<WallpapersPicture>
)