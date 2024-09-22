package com.example.rockpaperscissorsgame.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rockpaperscissorsgame.R
import com.example.rockpaperscissorsgame.game.GameManager
import com.example.rockpaperscissorsgame.game.Weapon

class SecondActivity : AppCompatActivity() {
    companion object {
        const val KEY_USER_CHOICE = "KEY_USER_CHOICE"
        const val KEY_COMPUTER_CHOICE = "KEY_COMPUTER_CHOICE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        backToMainActivityListener()

        val choiceUserOrdinal = intent.getIntExtra(KEY_USER_CHOICE, 0)
        val choiceComputerOrdinal = intent.getIntExtra(KEY_COMPUTER_CHOICE, 0)

        val choiceUser = Weapon.entries[choiceUserOrdinal]
        val choiceComputer = Weapon.entries[choiceComputerOrdinal]

        val result = GameManager.getGameResult(choiceUser, choiceComputer)

        findViewById<TextView>(R.id.text_result).text = result

        findViewById<TextView>(R.id.text_player_choice).text = "You chose: ${choiceUser.text}"
        findViewById<TextView>(R.id.text_computer_choice).text = "Opponent chose: ${choiceComputer.text}"
    }

    private fun backToMainActivityListener() {
        findViewById<Button>(R.id.button_back).setOnClickListener {
            this.finish()
        }
    }

}
