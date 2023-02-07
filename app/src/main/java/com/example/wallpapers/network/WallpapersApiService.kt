package com.example.wallpapers.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://pixabay.com/api/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client: OkHttpClient = OkHttpClient.Builder()
    .readTimeout(30, TimeUnit.SECONDS)
    .connectTimeout(30, TimeUnit.SECONDS)
    .build()  // socket timeout

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

/**
 * A public interface that exposes the [getPictures] method
 */
interface WallpapersApiService {
    /**
     * Returns a [List] of [WallpapersPicture] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "KEY" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("?key=33106230-b104905cd7ff74ed17e2229af")
    suspend fun getPictures(@Query("category") category: String): Hits
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object WallpapersApi {
    val retrofitService: WallpapersApiService by lazy { retrofit.create(WallpapersApiService::class.java) }
}