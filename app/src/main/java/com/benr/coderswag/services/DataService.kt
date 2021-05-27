package com.benr.coderswag.services

import com.benr.coderswag.model.Category
import com.benr.coderswag.model.Product

object DataService {
    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage"),
        // Duplicating categories to create a lot of categories. This was to demonstrate that having to scroll through a lot of category rows in the UI may not be smooth when the UI needs to create a lot of rows without using the View Holder pattern.
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage"),
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage")
    )

    private val hats = listOf(
        Product("Devslopes Graphic Beanie", "£18", "hat1"),
        Product("Devslopes Hat Black", "£20", "hat2"),
        Product("Devslopes Hat White", "£22", "hat3"),
        Product("Devslopes Hat Snapback", "£22", "hat4"),
        Product("Devslopes Graphic Beanie", "£18", "hat1"),
        Product("Devslopes Hat Black", "£20", "hat2"),
        Product("Devslopes Hat White", "£22", "hat3"),
        Product("Devslopes Hat Snapback", "£22", "hat4"),
        Product("Devslopes Graphic Beanie", "£18", "hat1"),
        Product("Devslopes Hat Black", "£20", "hat2"),
        Product("Devslopes Hat White", "£22", "hat3"),
        Product("Devslopes Hat Snapback", "£22", "hat4")
    )

    private val hoodies = listOf(
        Product("Devslopes Hoodie Gray", "£28", "hoodie1"),
        Product("Devslopes Hoodie Red", "£32", "hoodie2"),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3"),
        Product("Devslopes Black Hoodie", "£32", "hoodie4"),
        Product("Devslopes Hoodie Gray", "£28", "hoodie1"),
        Product("Devslopes Hoodie Red", "£32", "hoodie2"),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3"),
        Product("Devslopes Black Hoodie", "£32", "hoodie4"),
        Product("Devslopes Hoodie Gray", "£28", "hoodie1"),
        Product("Devslopes Hoodie Red", "£32", "hoodie2"),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3"),
        Product("Devslopes Black Hoodie", "£32", "hoodie4")
    )

    private val shirts = listOf(
        Product("Devslopes Shirt Black", "£18", "shirt1"),
        Product("Devslopes Badge Light Gray", "£20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3"),
        Product("Devslopes Hustle", "£22", "shirt4"),
        Product("Kickflip Studios", "£18", "shirt5"),
        Product("Devslopes Shirt Black", "£18", "shirt1"),
        Product("Devslopes Badge Light Gray", "£20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3"),
        Product("Devslopes Hustle", "£22", "shirt4"),
        Product("Kickflip Studios", "£18", "shirt5"),
        Product("Devslopes Shirt Black", "£18", "shirt1"),
        Product("Devslopes Badge Light Gray", "£20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3"),
        Product("Devslopes Hustle", "£22", "shirt4"),
        Product("Kickflip Studios", "£18", "shirt5")
    )

    private val digitalGoods = listOf<Product>()

    fun getProducts(category: String): List<Product> {
        return when (category) {
            "SHIRTS" -> shirts
            "HOODIES" -> hoodies
            "HATS" -> hats
            else -> digitalGoods
        }
    }
}