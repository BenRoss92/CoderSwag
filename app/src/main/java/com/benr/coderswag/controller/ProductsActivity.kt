package com.benr.coderswag.controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benr.coderswag.utilities.EXTRA_CATEGORY
import com.benr.coderswag.R
import com.benr.coderswag.adapters.ProductsAdapter
import com.benr.coderswag.services.DataService
import com.benr.coderswag.utilities.EXTRA_PRODUCT_DETAIL

class ProductsActivity : AppCompatActivity() {

    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Get the category title from the intent extra
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        val products = DataService.getProducts(categoryType!!)

        productsAdapter = ProductsAdapter(this, products) {
            val productDetailIntent = Intent(this, ProductDetailActivity::class.java)

            productDetailIntent.putExtra(EXTRA_PRODUCT_DETAIL, it)

            startActivity(productDetailIntent)
        }

        val productsListView = findViewById<RecyclerView>(R.id.productsListView)
        productsListView.adapter = productsAdapter

        var spanCount = 2

        // Get the current orientation of the device (landscape or portrait)
        val orientation = resources.configuration.orientation

        // If landscape, increase the column size to 3
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        // Get the width of the device
        val screenWidth = resources.configuration.screenWidthDp

        // If extra large device (i.e. width is greater than 720dp), increase column size to 3 (and landscape column should still be 3)
        if (screenWidth > 720) {
            spanCount = 3
        }

        // Create a horizontal grid (grid layout), not a list (linear layout)
        val gridLayoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = gridLayoutManager
    }
}