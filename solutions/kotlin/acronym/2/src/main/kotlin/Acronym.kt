object Acronym {
    fun generate(phrase: String) : String {
        return phrase.split(" ", "-", "_")
            .filter { it.isNotEmpty() }
            .map(String::first)
            .joinToString(separator = "")
            .uppercase()
    }
}
