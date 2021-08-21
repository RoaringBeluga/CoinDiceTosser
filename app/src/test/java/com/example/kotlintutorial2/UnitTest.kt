package com.example.kotlintutorial2

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun coinDice_createCoin() {
        assertEquals("Wrong CoinDice type!", "coin", CoinDice("coin").type())
    }

    @Test
    fun coinDice_createDice() {
        assertEquals("Wrong CoinDice type!", "dice", CoinDice().type())
    }

    @Test
    fun coinDice_diceWithinBounds() {
        val troll = CoinDice().troll();
        val ball = arrayOf("1", "2", "3", "4", "5", "6")
        assertTrue("Dice throw produced wrong result!", (troll in ball))
    }

    @Test
    fun coinDice_coinWithinBounds() {
        val troll = CoinDice("coin").troll();
        val ball = arrayOf("Heads", "Tails")
        assertTrue("Dice throw produced wrong result!", (troll in ball))
    }
}