package com.garv.wishlist.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDAO: WishDAO) {

    suspend fun AddWish(wish: Wish) {
        wishDAO.AddWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDAO.getAllWishes()

    fun getWishesByID(id: Long): Flow<Wish> = wishDAO.getAllWishesByID(id)

    suspend fun updateWish(wish: Wish) {
        wishDAO.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish) {
        wishDAO.deleteWish(wish)
    }
}