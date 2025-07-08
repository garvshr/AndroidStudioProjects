package com.garv.wishlist

import android.content.Context
import androidx.room.Room
import com.garv.wishlist.data.WishDatabase
import com.garv.wishlist.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDAO = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}