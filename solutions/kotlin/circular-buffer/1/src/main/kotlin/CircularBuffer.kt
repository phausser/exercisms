import kotlin.collections.ArrayDeque

// TODO: implement proper exceptions to complete the task
class EmptyBufferException : Exception()

class BufferFullException : Exception()

class CircularBuffer<T> constructor(val size: Int) {
    val buffer: ArrayDeque<T> = ArrayDeque(size)

    fun read() : T {
        if (buffer.isEmpty()) {
            throw EmptyBufferException()
        }

        return buffer.removeFirst()
    }

    fun write(value: T) {
        if (buffer.size == size) {
            throw BufferFullException()
        }

        buffer.addLast(value)
    }

    fun overwrite(value: T) {
        if (buffer.size == size) {
            buffer.removeFirst()
        }

        buffer.addLast(value)
    }

    fun clear() {
        buffer.clear()
    }
}