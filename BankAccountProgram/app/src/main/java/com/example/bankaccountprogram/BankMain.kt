package com.example.bankaccountprogram

fun main()
{
    var garvBank = BankAccount("Garv", 3500.0)
    garvBank.deposit(350.0)
    garvBank.withdraw(1200.0)
    garvBank.deposit(3150.0)
    garvBank.displayTransactions()

    println("${garvBank.accountHolder}'s bank balance is ${garvBank.balance}")
}