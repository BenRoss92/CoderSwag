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
        Product("Devslopes Graphic Beanie", "£18", "hat1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc nec odio non nibh pharetra vehicula viverra et mauris. Suspendisse potenti. Nullam et tempus ligula. Duis fringilla, lectus ut tempor faucibus, eros eros tristique dui, ut sagittis est mauris vel nulla. Morbi gravida ullamcorper metus sit amet consequat. Sed scelerisque pharetra purus, et placerat lacus commodo eu. Nunc cursus faucibus bibendum. Nulla ipsum lacus, euismod ac lacus sed, scelerisque accumsan augue. Morbi tincidunt lorem tincidunt nulla commodo faucibus."),
        Product("Devslopes Hat Black", "£20", "hat2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
        Product("Devslopes Hat White", "£22", "hat3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum scelerisque nibh et tellus condimentum, in mollis sem viverra. Integer vel enim in eros placerat euismod. Mauris ex magna, tristique vel."),
        Product("Devslopes Hat Snapback", "£22", "hat4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit."),
        Product("Devslopes Graphic Beanie", "£18", "hat1", "Lorem ipsum dolor sit amet."),
        Product("Devslopes Hat Black", "£20", "hat2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec molestie."),
        Product("Devslopes Hat White", "£22", "hat3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sit amet commodo libero. Aenean sed."),
        Product("Devslopes Hat Snapback", "£22", "hat4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc a ex tortor. Praesent purus sem, efficitur non felis tincidunt, pretium convallis sapien. Etiam convallis orci."),
        Product("Devslopes Graphic Beanie", "£18", "hat1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porta ac nisl ac commodo. Vestibulum mauris ex, viverra euismod quam sed, venenatis malesuada felis. Duis non arcu vestibulum, eleifend ante."),
        Product("Devslopes Hat Black", "£20", "hat2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vel nunc sapien. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam eget felis risus. Nulla risus mi, laoreet eu auctor eu."),
        Product("Devslopes Hat White", "£22", "hat3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vehicula, turpis quis sagittis accumsan, augue urna commodo est, ac pellentesque tortor turpis nec diam. Nulla sed ornare odio. Donec accumsan ac justo ac congue. Nullam fringilla dapibus sem id suscipit."),
        Product("Devslopes Hat Snapback", "£22", "hat4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque bibendum ex turpis, eget aliquam odio porta tempus. Quisque volutpat aliquam dui in bibendum. Etiam ante ante, egestas eu pharetra sit amet, vehicula id sem. Suspendisse fringilla purus eros, eu egestas est laoreet quis. Donec dignissim.")
    )

    private val hoodies = listOf(
        Product("Devslopes Hoodie Gray", "£28", "hoodie1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc nec odio non nibh pharetra vehicula viverra et mauris. Suspendisse potenti. Nullam et tempus ligula. Duis fringilla, lectus ut tempor faucibus, eros eros tristique dui, ut sagittis est mauris vel nulla. Morbi gravida ullamcorper metus sit amet consequat. Sed scelerisque pharetra purus, et placerat lacus commodo eu. Nunc cursus faucibus bibendum. Nulla ipsum lacus, euismod ac lacus sed, scelerisque accumsan augue. Morbi tincidunt lorem tincidunt nulla commodo faucibus."),
        Product("Devslopes Hoodie Red", "£32", "hoodie2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum scelerisque nibh et tellus condimentum, in mollis sem viverra. Integer vel enim in eros placerat euismod. Mauris ex magna, tristique vel."),
        Product("Devslopes Black Hoodie", "£32", "hoodie4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit."),
        Product("Devslopes Hoodie Gray", "£28", "hoodie1", "Lorem ipsum dolor sit amet."),
        Product("Devslopes Hoodie Red", "£32", "hoodie2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec molestie."),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sit amet commodo libero. Aenean sed."),
        Product("Devslopes Black Hoodie", "£32", "hoodie4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc a ex tortor. Praesent purus sem, efficitur non felis tincidunt, pretium convallis sapien. Etiam convallis orci."),
        Product("Devslopes Hoodie Gray", "£28", "hoodie1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porta ac nisl ac commodo. Vestibulum mauris ex, viverra euismod quam sed, venenatis malesuada felis. Duis non arcu vestibulum, eleifend ante."),
        Product("Devslopes Hoodie Red", "£32", "hoodie2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vel nunc sapien. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam eget felis risus. Nulla risus mi, laoreet eu auctor eu."),
        Product("Devslopes Gray Hoodie", "£28", "hoodie3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vehicula, turpis quis sagittis accumsan, augue urna commodo est, ac pellentesque tortor turpis nec diam. Nulla sed ornare odio. Donec accumsan ac justo ac congue. Nullam fringilla dapibus sem id suscipit."),
        Product("Devslopes Black Hoodie", "£32", "hoodie4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque bibendum ex turpis, eget aliquam odio porta tempus. Quisque volutpat aliquam dui in bibendum. Etiam ante ante, egestas eu pharetra sit amet, vehicula id sem. Suspendisse fringilla purus eros, eu egestas est laoreet quis. Donec dignissim.")
    )

    private val shirts = listOf(
        Product("Devslopes Shirt Black", "£18", "shirt1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc nec odio non nibh pharetra vehicula viverra et mauris. Suspendisse potenti. Nullam et tempus ligula. Duis fringilla, lectus ut tempor faucibus, eros eros tristique dui, ut sagittis est mauris vel nulla. Morbi gravida ullamcorper metus sit amet consequat. Sed scelerisque pharetra purus, et placerat lacus commodo eu. Nunc cursus faucibus bibendum. Nulla ipsum lacus, euismod ac lacus sed, scelerisque accumsan augue. Morbi tincidunt lorem tincidunt nulla commodo faucibus."),
        Product("Devslopes Badge Light Gray", "£20", "shirt2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum scelerisque nibh et tellus condimentum, in mollis sem viverra. Integer vel enim in eros placerat euismod. Mauris ex magna, tristique vel."),
        Product("Devslopes Hustle", "£22", "shirt4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit."),
        Product("Kickflip Studios", "£18", "shirt5", "Lorem ipsum dolor sit amet."),
        Product("Devslopes Shirt Black", "£18", "shirt1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec molestie."),
        Product("Devslopes Badge Light Gray", "£20", "shirt2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sit amet commodo libero. Aenean sed."),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc a ex tortor. Praesent purus sem, efficitur non felis tincidunt, pretium convallis sapien. Etiam convallis orci."),
        Product("Devslopes Hustle", "£22", "shirt4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porta ac nisl ac commodo. Vestibulum mauris ex, viverra euismod quam sed, venenatis malesuada felis. Duis non arcu vestibulum, eleifend ante."),
        Product("Kickflip Studios", "£18", "shirt5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vel nunc sapien. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam eget felis risus. Nulla risus mi, laoreet eu auctor eu."),
        Product("Devslopes Shirt Black", "£18", "shirt1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras vehicula, turpis quis sagittis accumsan, augue urna commodo est, ac pellentesque tortor turpis nec diam. Nulla sed ornare odio. Donec accumsan ac justo ac congue. Nullam fringilla dapibus sem id suscipit."),
        Product("Devslopes Badge Light Gray", "£20", "shirt2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque bibendum ex turpis, eget aliquam odio porta tempus. Quisque volutpat aliquam dui in bibendum. Etiam ante ante, egestas eu pharetra sit amet, vehicula id sem. Suspendisse fringilla purus eros, eu egestas est laoreet quis. Donec dignissim."),
        Product("Devslopes Logo Shirt Red", "£22", "shirt3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc nec odio non nibh pharetra vehicula viverra et mauris. Suspendisse potenti. Nullam et tempus ligula. Duis fringilla, lectus ut tempor faucibus, eros eros tristique dui, ut sagittis est mauris vel nulla. Morbi gravida ullamcorper metus sit amet consequat. Sed scelerisque pharetra purus, et placerat lacus commodo eu. Nunc cursus faucibus bibendum. Nulla ipsum lacus, euismod ac lacus sed, scelerisque accumsan augue. Morbi tincidunt lorem tincidunt nulla commodo faucibus."),
        Product("Devslopes Hustle", "£22", "shirt4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
        Product("Kickflip Studios", "£18", "shirt5", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum scelerisque nibh et tellus condimentum, in mollis sem viverra. Integer vel enim in eros placerat euismod. Mauris ex magna, tristique vel.")
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