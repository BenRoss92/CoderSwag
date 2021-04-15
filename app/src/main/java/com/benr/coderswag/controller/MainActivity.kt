package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benr.coderswag.R
import com.benr.coderswag.adapters.CategoryAdapter
import com.benr.coderswag.adapters.CategoryRecyclerAdapter
import com.benr.coderswag.services.DataService

class MainActivity : AppCompatActivity() {

    /**
     * An Adapter is a bridge between the model layer and the view layer.
     *
     * Our Array Adapter takes our data (the Singleton categories array),
     * transforms each array item into a View object (something that can be shown in the UI, e.g. buttons, spinners, etc. are Views)
     * and then inserts those Views into the ListView (which groups and lists multiple Views together
     * in whatever way you want).
     *
     * Create a variable for the Adapter outside of the onCreate lifecycle method
     * so that we can reference it in different lifecycle methods if we want/need to.
     */
    // Swap the CategoryAdapter for the CategoryRecyclerAdapter
    private lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the array of Category instances
        val categories = DataService.categories

        // Instantiate our custom CategoryAdapter
        adapter = CategoryRecyclerAdapter(this, categories)

        // Get the RecyclerView that we want to display our category titles within
        val listView = findViewById<RecyclerView>(R.id.categoryListView)

        // Tell the RecyclerView to use our custom CategoryRecyclerAdapter
        listView.adapter = adapter

        // Create and set the LayoutManager to be a LinearLayoutManager (i.e. a vertically scrolling list)
        val linearLayoutManager = LinearLayoutManager(this)
        listView.layoutManager = linearLayoutManager

        // Performance boost - tell Android that every Category list item UI component will be the same fixed size.
        listView.setHasFixedSize(true)
    }
}
