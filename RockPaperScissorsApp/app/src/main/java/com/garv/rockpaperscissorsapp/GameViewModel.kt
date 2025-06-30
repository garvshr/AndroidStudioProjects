package com.garv.rockpaperscissorsapp


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    val playerMove = mutableStateOf<Move?>(null)
    val computerMove = mutableStateOf<Move?>(null)
    val result = mutableStateOf("")

    fun getMoves(player: Move) {
        val computer  = Move.entries.random()
        playerMove.value = player
        computerMove.value = computer
        result.value = getWinner(
            player = player,
            computer = computer
        )
    }

    fun reset() {
        playerMove.value = null
        computerMove.value = null
        result.value = ""
    }

    private fun getWinner(player: Move, computer: Move): String
    {
        return when {

            player == computer -> "Its A Draw"
            player == Move.ROCK && computer == Move.SCISSORS -> "🏆 You Won !"
            player == Move.SCISSORS && computer == Move.PAPER -> "🏆 You Won !"
            player == Move.PAPER && computer == Move.ROCK -> "🏆 You Won !"
            else -> "You Lose ;("

        }
    }

}