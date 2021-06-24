package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.benr.coderswag.R
import com.benr.coderswag.model.Product
import com.benr.coderswag.utilities.EXTRA_PRODUCT_DETAIL

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Get the product data from the intent used to start this activity
        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT_DETAIL)

        // get the Image View from the layout file
        val productDetailImage = findViewById<ImageView>(R.id.productdetailimage)
        val productDetailName = findViewById<TextView>(R.id.productdetailname)
        val productDetailDescription = findViewById<TextView>(R.id.productdetaildescription)
        val productDetailPrice = findViewById<TextView>(R.id.productdetailprice)

        // get image resource ID to be able to set the correct image resource file for the product
        val imageResourceId = resources.getIdentifier(product.image, "drawable", packageName)

        // Dynamically add the product data to the Views in the activity_product_detail.xml layout
        productDetailImage.setImageResource(imageResourceId)
        productDetailName.text = product.title
        productDetailPrice.text = product.price
        productDetailDescription.text = product.description
    }
}