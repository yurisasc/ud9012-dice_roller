package com.cakranegara.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // lateinit ensures that the variable will be initialized before any calls to it
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Log.d("BUTTON_CLICK_EVENT", "Roll button clicked.")
            rollDice()
        }

        // minimize the number of findViewById calls (reduce lag) by initializing it once here
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1

        // map the resulting random integer to a drawable resource
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // diceImage could be initialized here, but it's not good for the app performance
        // calling findViewById many times can cause lag
        diceImage.setImageResource(drawableResource)
    }
}
