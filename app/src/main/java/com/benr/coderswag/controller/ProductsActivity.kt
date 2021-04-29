package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benr.coderswag.utilities.EXTRA_CATEGORY
import com.benr.coderswag.R

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Get the category title from the intent extra
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)
    }
}