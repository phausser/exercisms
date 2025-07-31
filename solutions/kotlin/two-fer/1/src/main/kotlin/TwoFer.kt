internal fun twofer(name: String? = null): String {
    val outName = if (name == null) {
        "you"
    } else {
        name
    }

    return "One for $outName, one for me."
}
