package com.example.wallpapers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * MainActivity sets the content view activity_main, a fragment container.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}