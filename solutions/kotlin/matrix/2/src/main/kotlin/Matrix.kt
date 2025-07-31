class Matrix(private val matrixAsString: String) {
    private val matrixAsList: List<List<Int>> = matrixAsString
        .lines()
        .map {
            it
                .split(' ')
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
        }

    fun column(colNr: Int): List<Int> {
        return matrixAsList.map { it.get(colNr - 1) }
    }

    fun row(rowNr: Int): List<Int> {
        return matrixAsList.get(rowNr - 1)
    }
}
