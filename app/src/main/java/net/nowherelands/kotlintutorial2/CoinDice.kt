package net.nowherelands.kotlintutorial2

class CoinDice(
    type: String = "dice"
) {
    private val theType: String = if(type=="dice") type else "coin"

    fun troll(): String {
        return if (theType=="coin")
            if ((1..2).random() == 1) "Heads" else "Tails"
        else
            "${(1..6).random()}"
    }

    fun type(): String {
        return this.theType
    }
}