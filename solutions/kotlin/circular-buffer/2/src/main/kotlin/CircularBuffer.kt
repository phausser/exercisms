import java.lang.RuntimeException
import kotlin.collections.ArrayDeque

class EmptyBufferException : RuntimeException()

class BufferFullException : RuntimeException()

class CircularBuffer<T> constructor(val size: Int) {
    private val buffer: ArrayDeque<T> = ArrayDeque(size)

    fun read(): T {
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