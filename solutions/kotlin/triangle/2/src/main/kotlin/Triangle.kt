class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        val sides = listOf(a, b, c).map { it.toDouble() }
        require(sides.all { it > 0 } && sides.sorted().let { it[0] + it[1] > it[2] }) { "This is no triangle!" }
    }

    private val diffSides = setOf(a, b, c).size

    val isEquilateral: Boolean = diffSides == 1
    val isIsosceles: Boolean = diffSides <= 2
    val isScalene: Boolean = diffSides == 3
}
