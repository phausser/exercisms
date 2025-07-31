object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val cleanedText = plaintext
            .lowercase()
            .filter(Char::isLetterOrDigit)

        if (cleanedText.isEmpty()) return ""

        val rows = kotlin.math.ceil(
            kotlin.math.sqrt(cleanedText.length.toDouble())
        ).toInt()
        val squareText = cleanedText.chunked(rows) {
            it.padEnd(rows, ' ')
        }

        return (0 until rows).joinToString(" ") { i ->
            squareText.joinToString("") { it[i].toString() }
        }
    }
}
