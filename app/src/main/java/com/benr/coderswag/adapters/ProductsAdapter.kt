package com.benr.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benr.coderswag.R
import com.benr.coderswag.model.Product

class ProductsAdapter(private val context: Context, private val products: List<Product>, private val itemClick: (Product) -> Unit): RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Get the UI elements (Views) from the View object being passed into the ViewHolder (ProductHolder) - Product image, product name view, product price view
        private val productImageView = itemView.findViewById<ImageView>(R.id.productimage)
        private val productNameView: TextView = itemView.findViewById(R.id.productname)
        private val productPriceView = itemView.findViewById<TextView>(R.id.productprice)

        fun bind(product: Product) {
            // Get the correct image from the resource folder based on the product's image name
                // You can't use the R object because you don't know what the name of the file is - it dynamically changes
                // You can't use findViewById because it's not a view - it's a drawable file.
            val imageId = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            // set the product image view to be the product's image name
            productImageView.setImageResource(imageId)

            // set the product name view to be the product's name
            productNameView.text = product.title
            // set the product price view to be the product's price
            productPriceView.text = product.price
            itemView.setOnClickListener { itemClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        // get the view by inflating it from the layout file
        val productView = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.count()
    }
}