class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        require(a.toFloat() * b.toFloat() * c.toFloat() > 0) { "No side must be zero!" }
        require(listOf<Float>(a.toFloat(), b.toFloat(), c.toFloat()).sorted()
            .let { it[0] + it[1] >= it[2] }) { "Sum of smallest sides must be bigger than biggest side!" }
    }

    val isEquilateral: Boolean = setOf(a, b, c).size == 1
    val isIsosceles: Boolean = setOf(a, b, c).size <= 2
    val isScalene: Boolean = setOf(a, b, c).size == 3
}
