package com.example.rockpaperscissorsgame.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rockpaperscissorsgame.R
import com.example.rockpaperscissorsgame.game.GameManager
import com.example.rockpaperscissorsgame.game.Weapon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupButtonListeners()

    }

    private fun setupButtonListeners() {
        findViewById<Button>(R.id.button_papper).setOnClickListener {
            executeNextActivity(Weapon.PAPER)
        }

        findViewById<Button>(R.id.button_rock).setOnClickListener {
            executeNextActivity(Weapon.ROCK)
        }

        findViewById<Button>(R.id.button_scissors).setOnClickListener {
            executeNextActivity(Weapon.SCISSORS)
        }
    }

    private fun executeNextActivity(choice: Weapon) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_USER_CHOICE, choice.ordinal)
        intent.putExtra(SecondActivity.KEY_COMPUTER_CHOICE, GameManager.getRandomWeapon().ordinal)
        startActivity(intent)
    }

}