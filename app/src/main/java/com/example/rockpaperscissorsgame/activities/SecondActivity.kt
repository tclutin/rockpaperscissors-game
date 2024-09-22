package com.example.rockpaperscissorsgame.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rockpaperscissorsgame.R
import com.example.rockpaperscissorsgame.game.GameManager

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.button_back).setOnClickListener {
            this.finish()
        }

        val choicePlayer = intent.getStringExtra("KEY_USER")
        val choiceComputer = intent.getStringExtra("KEY_COMPUTER")


        findViewById<TextView>(R.id.text_player_choice).text = "You have chosen: $choicePlayer"
        findViewById<TextView>(R.id.text_computer_choice).text = "Opponent chose: $choiceComputer"
    }
}