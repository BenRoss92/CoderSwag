package com.benr.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benr.coderswag.R
import com.benr.coderswag.model.Category

// Using a RecyclerView (UI component) to display the list of categories in, instead of using a ListView.
// Created a custom RecyclerAdapter for the RecyclerView to use.
// Using a RecyclerView instead of a ListView to force us to implement performant code by forcing us to use a ViewHolder. With the ListView, using a ViewHolder is optional. We want it to be required instead of optional. The RecyclerView forces your custom adapter (the RecyclerAdapter) to use a ViewHolder.

// Extends the built-in RecyclerView.Adapter class which will use our custom ViewHolder class (our Holder class which extends the RecyclerView.ViewHolder class).
class CategoryRecyclerAdapter(private val context: Context, private val categories: List<Category>, private val itemClick: (Category) -> Unit): RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // Get the ID of the layout XML file for a single category list item
        val layoutId = R.layout.category_list_item

        // Inflate the layout for a single category
        val layoutInflater = LayoutInflater.from(context)
        val categoryItemView = layoutInflater.inflate(layoutId, parent, false)

        // Create a new instance of the ViewHolder which will grab the Text and Image views from the inflated view and hold references to those Views
        return Holder(categoryItemView, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // Grab the data from our model and "bind" that data to the same recycled (reused) Text and Image Views.
        val categoryInstance = categories[position]

        holder.bindCategory(categoryInstance, context)
    }

    override fun getItemCount(): Int {
        // Tell the adapter how many categories we have
        return categories.count()
    }

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        // Grab the resource IDs of the Text and Image Views
        private val categoryNameElementId = R.id.categoryName
        private val categoryImageElementId = R.id.categoryImage

        // Grab the Text and Image Views from the inflated single Category list item View
        private val categoryTextView: TextView = itemView.findViewById<TextView>(categoryNameElementId)
        private val categoryImageView: ImageView = itemView.findViewById<ImageView>(categoryImageElementId)

        fun bindCategory(category: Category, context: Context) {
            // Get the image file path
            val categoryImageName = category.image

            // Dynamically fetch the ID of whichever image resource file is related to the current category
            val imageResourceId = context.resources.getIdentifier(categoryImageName, "drawable", context.packageName)

            // "Bind" the correct image and text data to the current Image and Text View
            categoryImageView.setImageResource(imageResourceId)
            categoryTextView.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }

}