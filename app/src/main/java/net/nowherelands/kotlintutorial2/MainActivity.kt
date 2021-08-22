package net.nowherelands.kotlintutorial2

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private var rollType = "dice"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trollResults: TextView = findViewById(R.id.tossed_results)
        val roflButton: Button = findViewById(R.id.btn_roll)
        val switchCoinDice: SwitchCompat = findViewById(R.id.switch_is_coin)
        val coinDiceImage: ImageView = findViewById(R.id.coinDicePic)

        var plopped = false
        var moved = false

        roflButton.setOnClickListener {

            val coined = CoinDice(rollType)
            val rollResult = coined.troll()
            val imgID = when(rollResult) {
                "Heads" -> R.drawable.coin_1
                "Tails" -> R.drawable.coin_2
                "1" -> R.drawable.dice_1
                "2" -> R.drawable.dice_2
                "3" -> R.drawable.dice_3
                "4" -> R.drawable.dice_4
                "5" -> R.drawable.dice_5
                "6" -> R.drawable.dice_6
                else -> R.drawable.dice_6
            }
            coinDiceImage.setImageResource(imgID)
            coinDiceImage.contentDescription = rollResult
            getString(R.string.troll_message, if(rollType=="dice") "Rolled" else "Tossed", rollResult).also { trollResults.text = it }
            Log.d("CoinDice", "${if (rollType=="dice") "Rolled" else "Tossed"} result: ${rollResult}")
            coinDiceImage.contentDescription = rollResult

        }

        switchCoinDice.setOnCheckedChangeListener { _, isChecked ->
            this.rollType = if (isChecked) "coin" else "dice"
            coinDiceImage.setImageResource(0)
            roflButton.setText(if(isChecked) R.string.btn_toss else R.string.btn_roll)
            trollResults.setText("")
            Log.d("CoinDice", "Set rolltype to ${this.rollType}")
        }

        coinDiceImage.setOnClickListener() {
            Log.wtf("CoinDice", "Someone touched the CoinDice!")
        }

        coinDiceImage.setOnTouchListener() { _, laEvent ->
            Log.d("CoinDice", laEvent.toString())
            val action = laEvent.action
            when(action) {
                MotionEvent.ACTION_DOWN -> {
                    plopped = true
                    Log.d("CoinDice", "Touched down")
                }
                MotionEvent.ACTION_MOVE -> {
                    moved = true
                    Log.d("CoinDice", "Moved - Touch-and-move started, roll/toss imminent")
                }
                MotionEvent.ACTION_UP -> {
                    if (plopped && moved) {
                        plopped = false
                        moved = false
                        roflButton.performClick()
                        Log.d("CoinDice", "Touch-and-moved on the image - rolling/tossing")
                    }
                }
            }
            super.onTouchEvent(laEvent)
        }
    }

}