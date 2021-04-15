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

// No longer being used - left here as guy in video didn't delete this file for some reason.
// Replaced this class with the CategoryRecyclerAdapter.
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

    /**
     * When we have multiple copies of our categories in our category list (e.g. 3 times as many as we have right now) - Use a View Holder to avoid Android from having to inflate and manipulate a new View each time getView is called (this can reduce performance - scrolling might be choppy/not as smooth). It's a heavy amount of computation if you don't use View Holders as getView is called multiple times.
     *
     * Only inflate the layout file (creating a new View object) if Android hasn't displayed all of our categories (without the need to scroll).
     *
     * If haven't scrolled yet (i.e if the view hasn't changed yet):
     *  - Create a View Holder object
     *  - Store the resource IDs of the Category image and category name from the inflated layout object for next time our adapter calls getView
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // The View Holder pattern is a common android pattern. The reason we use the View Holder pattern is to avoid needing to call `findViewById` many times as it's computationally expensive and can affect the smoothness of scrolling. Our ViewHolder will store references to the View objects we need to change (i.e. the TextView and ImageView in our single row), so that we don't have to call `findViewById` every time a new row is being created.
        var holder: ViewHolder
        // The View of our single row that we want to display (i.e. return from `getView`).
        var categoryItemView: View

        // You don't need to get access to the categoryListView UI element here (i.e. inside of your custom adapter). You reference it later on in the activity (MainActivity) when setting the adapter of the categoryListView UI element to be our custom adapter. You need to do it in the MainActivity because that's where we're going to pass in the list of category instances.

        // Our adapter will just reference a single category list item in this method, not the whole category list - i.e. we only need to reference the category_list_item.xml Layout, as this represents one category item only.

        // Inflate the Layout for a single category list item so that you can programmatically change what the category name and category image should be for each category in the category list

        // Inflating the view (using LayoutInflater) is an expensive computation. We want to minimise the amount of times we have to inflate a view. To avoid inflating the view for every time we want a new row created, we can use `convertView`. `convertView` represents the previous row that was displayed (as a View object). `convertView` will be null if a row hasn't been displayed before (i.e. if this is the first row to be displayed). We only need to create the row manually (by inflating a view) when we haven't displayed a row before (i.e. when `convertView` is null). If we have created a row before, take the previous row displayed and reuse (recycle) it (i.e. assign our current row View to be the previous row View and then manipulate the text and image later).
        // If the user hasn't scrolled before: create a new View Holder, get the Text and Image Views from the inflated layout object and store them in the View Holder. Then the same TextView and ImageView can be reused for every new row (all we have to do is then change whatever data we want to display inside the TextView and ImageView).
        if (convertView == null) {
            // Create the View Holder where we'll store references to the Image and Text Views
            holder = ViewHolder()

            // Grab a reference to the layout XML file which will display a single category list item
            val layoutId = R.layout.category_list_item

            // Get a LayoutInflater and inflate the category_list_item.xml file to become an object that you can then manipulate here in the Kotlin code (i.e. the adapter)
            val layoutInflater = LayoutInflater.from(context)
            categoryItemView = layoutInflater.inflate(layoutId, null)

            // Grab View objects that you can manipulate for both the categoryName and categoryImage view components - first get the resource IDs of both of these view components (by accessing the R (i.e. Resources) class)). Then find the View objects of these components inside of the inflated category_list_item layout object using their resource IDs.
            val categoryNameElementId = R.id.categoryName
            val categoryImageElementId = R.id.categoryImage
            // get a reference to the single category TextView
            holder.categoryTextView = categoryItemView.findViewById<TextView>(categoryNameElementId)
            // get a reference to the single category ImageView
            holder.categoryImageView = categoryItemView.findViewById<ImageView>(categoryImageElementId)

            // The `tag` property (inside of the View object) can store whatever you want (it can be any type of Object).
            // Every time the `getView` method is called, new `categoryItemView` and `holder` variables will be created, therefore they won't store the previous row View and the references to the TextView and ImageView. The way around this is that the value of `categoryItemView` (the row View) will be assigned to `convertView` automatically by Android. So the next time `getView` is called automatically, `convertView` will have the same value as the previous `categoryItemView` value. We can store the current ViewHolder instance inside of `categoryItemView` by using the `tag` property (this property can be assigned any type of object). That way, the next time `getView` is called, `convertView` will be automatically assigned the previous value of `categoryItemView`, including whatever was stored in the `tag` property (i.e. the previous `ViewHolder` instance).
            categoryItemView.tag = holder
        } else {
            // As the `tag` property value can be any type of Object, we need to explicitly tell Android that its value is an instance of `ViewHolder` (this value was set during the last call to `getView`.
            // The `holder` and `categoryItemView` variables will be empty each time `getView` is called, so we need to assign them values.
            holder = convertView.tag as ViewHolder
            // If `getView` has been called previously by Android, Android will automatically assign `convertView` as the previous value of `categoryItemView`. Here we assign this value back to `categoryItemView` so that we can distinguish between the current row View that we have control over (`categoryItemView`) and the previous row View that Android has control over (`convertView`).
            categoryItemView = convertView
        }

        // Get the Category object for the single list item we're about to display
        val categoryInstance = categories[position]

        // Get the resource ID of the category's image based on the image name
        val imageId = context.resources.getIdentifier(categoryInstance.image, "drawable", context.packageName)
        // Set the value of the component displaying the image to be the correct resource ID
        holder.categoryImageView?.setImageResource(imageId)

        // Set the TextView's text to be whatever the dynamic value of the category instance's title is
        holder.categoryTextView?.text = categoryInstance.title

        // Return the manipulated View for the category list item
        return categoryItemView
    }

    // The View Holder will store references to the Image and Text Views
    private class ViewHolder {
        var categoryImageView: ImageView? = null
        var categoryTextView: TextView? = null
    }
}