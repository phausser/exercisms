object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val line = plaintext
            .lowercase()
            .filter { it.isLetterOrDigit() }

        val r = kotlin.math.ceil(
            kotlin.math.sqrt(line.length.toDouble())
        ).toInt()

        if (r == 0) return ""

        val square = line.chunked(r) {
            it.padEnd(r, ' ')
        }

        val result = (0 until r).map { i ->
            square.joinToString("") { it[i].toString() }
        }

        return result.joinToString(" ")
    }
}
