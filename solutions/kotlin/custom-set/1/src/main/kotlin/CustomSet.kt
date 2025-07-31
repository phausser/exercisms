class CustomSet(vararg element: Int) {
    val elements: MutableSet<Int> = mutableSetOf(*element.toTypedArray())

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return elements.all { it in other.elements }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return elements.none { it in other.elements }
    }

    fun contains(other: Int): Boolean {
        return elements.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return CustomSet(*elements.filter { it in other.elements }.toIntArray())
    }

    fun add(other: Int) {
        elements.add(other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CustomSet) return false

        return elements.size == other.elements.size &&
                intersection(other).elements.size == elements.size
    }

    operator fun plus(other: CustomSet): CustomSet {
        val newElements = elements.toMutableSet()
        newElements.addAll(other.elements)

        return CustomSet(*newElements.toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {
        val newElements = elements.toMutableSet()
        newElements.removeAll(other.elements)

        return CustomSet(*newElements.toIntArray())
    }
}
