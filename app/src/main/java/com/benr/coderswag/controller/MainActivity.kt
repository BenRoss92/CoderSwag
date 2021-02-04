package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benr.coderswag.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
 * Categories - SHIRTS, HOODIES, HATS - create an immutable array of categories
 * Products - create an array, each containing 4 products from each category (4 hats, 4 hoodies, etc.)
 * The arrays are immutable
 * Create the arrays inside of a singleton object - not sure what to call the file - check
 * Create a package called 'Services' where our singletons will live
 * Create a file called DataService.kt for our singleton object
 */