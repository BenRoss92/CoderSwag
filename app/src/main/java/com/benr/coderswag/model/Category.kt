package com.benr.coderswag.model

class Category(val title: String, val image: String) {

    /**
     * When the Array Adapter uses our array of Category instances,
     * without this override, the Category instances (i.e. objects)
     * would be printed instead of the title strings. i.e. Android
     * would instead print the IDs of where the data is stored in
     * memory, rather than the titles.
     */
    override fun toString(): String {
        return title
    }
}