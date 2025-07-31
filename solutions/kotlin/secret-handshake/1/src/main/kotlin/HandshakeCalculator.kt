object HandshakeCalculator {

    private fun Int.bitTest(bitNr: Int) = this.and(1.rotateLeft(bitNr)) > 0

    fun calculateHandshake(number: Int): List<Signal> {
        return listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP)
            .filterIndexed { i, _ -> number.bitTest(i) }
            .toMutableList()
            .apply { if (number.bitTest(4)) reverse() }
    }
}
