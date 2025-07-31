class Squares(private val n: Int) {

    fun sumOfSquares() = (1..n).map { it * it }.sum()

    fun squareOfSum() = (1..n).sum().let { it * it }

    fun difference() = squareOfSum() - sumOfSquares()
}
