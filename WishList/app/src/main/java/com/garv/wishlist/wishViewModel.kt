package com.garv.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garv.wishlist.data.Wish
import com.garv.wishlist.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class wishViewModel( private val wishRepository: WishRepository = Graph.wishRepository): ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        getAllWishes = wishRepository.getWishes()
    }

    fun addWishes(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.AddWish(wish)
        }
    }

    fun getWishByID(id: Long): Flow<Wish> {
        return wishRepository.getWishesByID(id)
    }

    fun updateWishes(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWishes(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }

}