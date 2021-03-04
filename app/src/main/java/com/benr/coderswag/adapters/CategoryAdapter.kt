package com.benr.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.benr.coderswag.R
import com.benr.coderswag.model.Category

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {
    private val context = context
    private val categories = categories

    override fun getCount(): Int {
        // return the size of the categories array
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        // returns the instance of Category in the array
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        // we're not using this method, but the compiler insists that we return a Long type here regardless, so we return 0.
        return 0
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * [android.view.LayoutInflater.inflate]
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position The position of the item within the adapter's data set of the item whose view
     * we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     * is non-null and of an appropriate type before using. If it is not possible to convert
     * this view to display the correct data, this method can create a new view.
     * Heterogeneous lists can specify their number of view types, so that this View is
     * always of the right type (see [.getViewTypeCount] and
     * [.getItemViewType]).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // You don't need to get access to the categoryListView UI element here (i.e. inside of your custom adapter). You reference it later on in the activity (MainActivity) when setting the adapter of the categoryListView UI element to be our custom adapter. You need to do it in the MainActivity because that's where we're going to pass in the list of category instances.

        // Our adapter will just reference a single category list item in this method, not the whole category list - i.e. we only need to reference the category_list_item.xml Layout, as this represents one category item only.

        // Inflate the Layout for a single category list item so that you can programmatically change what the category name and category image should be for each category in the category list

        // Grab a reference to the layout XML file which will display a single category list item
        val layoutId = R.layout.category_list_item

        // Get a LayoutInflater and inflate the category_list_item.xml file to become an object that you can then manipulate here in the Kotlin code (i.e. the adapter)
        val layoutInflater = LayoutInflater.from(context)
        val categoryItemView = layoutInflater.inflate(layoutId, null)

        // Grab View objects that you can manipulate for both the categoryName and categoryImage view components - first get the resource IDs of both of these view components (by accessing the R (i.e. Resources) class)). Then find the View objects of these components inside of the inflated category_list_item layout object using their resource IDs.
        val categoryNameElementId = R.id.categoryName
        val categoryImageElementId = R.id.categoryImage
        // get a reference to the single category TextView
        val textView = categoryItemView.findViewById<TextView>(categoryNameElementId)
        // get a reference to the single category ImageView
        val imageView = categoryItemView.findViewById<ImageView>(categoryImageElementId)

        // Get the Category object for the single list item we're about to display
        val categoryInstance = categories[position]

        // Get the resource ID of the category's image based on the image name
        val imageId = context.resources.getIdentifier(categoryInstance.image, "drawable", context.packageName)
        // Set the value of the component displaying the image to be the correct resource ID
        imageView.setImageResource(imageId)

        // Set the TextView's text to be whatever the dynamic value of the category instance's title is
        textView.text = categoryInstance.title

        // Return the newly inflated and manipulated View for the category list item
        return categoryItemView
    }
}