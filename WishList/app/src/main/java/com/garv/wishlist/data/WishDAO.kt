package com.garv.wishlist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun AddWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish_table` where id = :id")
    abstract fun getAllWishesByID(id: Long): Flow<Wish>
}