package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.benr.coderswag.R
import com.benr.coderswag.adapters.CategoryAdapter
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
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the array of Category instances
        val categories = DataService.categories

        // Instantiate our custom CategoryAdapter
        adapter = CategoryAdapter(this, categories)

        // Get the ListView that we want to display our category titles within
        val listView = findViewById<ListView>(R.id.categoryListView)

        // Tell the ListView to use our custom CategoryAdapter
        listView.adapter = adapter
    }
}
