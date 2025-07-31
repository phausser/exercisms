object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        return leftStrand
            .zip(rightStrand)
            .count { (a, b) -> !a.equals(b) }
    }
}
