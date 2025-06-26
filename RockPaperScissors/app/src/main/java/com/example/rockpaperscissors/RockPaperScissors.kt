package com.example.rockpaperscissors

fun main()
{
    var computerChoice =  ""
    var userChoice = ""
    println("Enter Rock, Paper or Scissors")

    userChoice = readln()
    val randomNumber = (1..3).random()
    when (randomNumber)
    {
        1 ->
            computerChoice = "Rock"
        2 ->
            computerChoice = "Paper"
        3 ->
            computerChoice = "Scissors"
    }

    println("Computer's Choice : $computerChoice")

    val winner = when
    {
        userChoice == computerChoice -> "Tie"
        userChoice == "Paper" && computerChoice == "Rock" -> "You Won"
        userChoice == "Scissors" && computerChoice == "Paper" -> "You Won"
        userChoice == "Rock" && computerChoice == "Scissors" -> "You Won"
        else -> "You Lost"
    }

    println(winner)
}
