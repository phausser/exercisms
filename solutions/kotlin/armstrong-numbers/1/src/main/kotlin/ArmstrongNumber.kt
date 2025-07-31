import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = input.toString().map { it.digitToInt().toDouble() }
        val sum = digits.sumOf { it.pow(digits.size) }.toInt()

        return input == sum
    }
}
