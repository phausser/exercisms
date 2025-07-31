object Acronym {
    fun generate(phrase: String) : String {
        return phrase.split(" ", "-", "_")
            .filter { it.isNotEmpty() }
            .map(String::first)
            .joinToString(separator = "") { it.uppercase() }
    }
}

fun main() {
    val phrase = "The Road _Not_ Taken"
    val acronym = Acronym.generate(phrase)
    println("The acronym for '$phrase' is '$acronym'.")
}