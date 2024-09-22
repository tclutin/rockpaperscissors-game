package com.example.rockpaperscissorsgame.game

enum class Weapon(val text: String) {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors")
}


object GameManager {
    const val WIN_TEXT = "You won! Opponent lost."
    const val LOSE_TEXT = "You lost! Opponent won."
    const val DRAW_TEXT = "It's a draw!"

    fun getGameResult(firstPlayer:  Weapon, secondPlayer:  Weapon): String {
        return when {
            firstPlayer == secondPlayer -> DRAW_TEXT
            (firstPlayer ==  Weapon.ROCK && secondPlayer == Weapon.SCISSORS) ||
                    (firstPlayer ==  Weapon.SCISSORS && secondPlayer ==  Weapon.PAPER) ||
                    (firstPlayer ==  Weapon.PAPER && secondPlayer ==  Weapon.ROCK) -> WIN_TEXT
            else -> LOSE_TEXT
        }
    }
}