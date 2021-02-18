package com.benr.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.benr.coderswag.R
import com.benr.coderswag.model.Category
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
    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the array of Category instances
        val categories = DataService.categories

        /**
         * Create the Adapter, passing it the context (the MainActivity), a built-in Android layout called 'simple_list_item_1' which
         * specifies that each array item will be a TextView (a layout is a UI component used to define the structure of the UI (e.g.
         * we add constraints using a ConstraintLayout), and the data we want to display (the array of Category instances)/
         */
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)

        /**
         * Get the ListView we want to display our category titles in
         *
         * FIXME: Kotlin Android Extensions (kotlinx) should be auto-importing
         * the ListView when I start typing 'categoryListView' on its own, but it doesn't.
         * It should be resulting in:
         * ```kt
         * import kotlinx.android.synthetic.main.activity_main.*
         * ```
         * but it doesn't.
         * So for now I'm getting the View the old-fashioned way.
         */
        val listView = findViewById<ListView>(R.id.categoryListView)

        // Tell the ListView to use our Array Adapter
        listView.adapter = adapter
    }
}
