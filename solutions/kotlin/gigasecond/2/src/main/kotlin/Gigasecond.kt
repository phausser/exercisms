import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(dateTime: LocalDateTime) {
    val date: LocalDateTime = dateTime.plusSeconds(1_000_000_000)

    constructor(dateOnly: LocalDate) : this(dateOnly.atStartOfDay())
}
