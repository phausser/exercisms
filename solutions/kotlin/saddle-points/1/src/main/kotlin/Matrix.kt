data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val data: List<List<Int>>) {

    val width: Int
        get() = data.first().size
    val height: Int
        get() = data.filter { it.isNotEmpty() }.size

    fun rowAt(index: Int) = data[index - 1]

    fun colAt(index: Int) = data.map { it.filterIndexed { i, _ -> i == index - 1 } }.flatten()

    fun rowWithCoordsAt(index: Int) =
        rowAt(index).mapIndexed { i, value -> Pair(MatrixCoordinate(index, i + 1), value) }

    fun colWithCoordsAt(index: Int) =
        colAt(index).mapIndexed { i, value -> Pair(MatrixCoordinate(i + 1, index), value) }

    fun allColsWithCoords() =
        ArrayList<List<Pair<MatrixCoordinate, Int>>>().apply { (1..width).map { i -> this.add(colWithCoordsAt(i)) } }

    fun allRowsWithCoords() =
        ArrayList<List<Pair<MatrixCoordinate, Int>>>().apply { (1..height).map { i -> this.add(rowWithCoordsAt(i)) } }

    val saddlePoints: Set<MatrixCoordinate>
        get() {
            val minCols =
                allColsWithCoords().map { val min = it.minOf { it.second }; it.filter { it.second == min } }.flatten()
            val maxRows =
                allRowsWithCoords().map { val max = it.maxOf { it.second }; it.filter { it.second == max } }.flatten()

            return minCols.intersect(maxRows).map { it.first }.toSet()
        }
}
