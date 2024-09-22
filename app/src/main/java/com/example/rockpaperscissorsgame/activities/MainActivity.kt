package com.example.rockpaperscissorsgame.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rockpaperscissorsgame.R

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
            executeNextActivity(getString(R.string.papper))
        }

        findViewById<Button>(R.id.button_rock).setOnClickListener {
            executeNextActivity(getString(R.string.rock))
        }

        findViewById<Button>(R.id.button_scissors).setOnClickListener {
            executeNextActivity(getString(R.string.scissors))
        }
    }

    private fun executeNextActivity(choice: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("KEY_USER", choice)
        intent.putExtra("KEY_COMPUTER", getRandomItem())
        startActivity(intent)
    }

    private fun getRandomItem(): String {
        return listOf<String>(
            getString(R.string.scissors),
            getString(R.string.rock),
            getString(R.string.papper)
        ).random()
    }
}