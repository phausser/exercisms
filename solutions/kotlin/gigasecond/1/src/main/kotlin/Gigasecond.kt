import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(fullDateTime: LocalDateTime) {

    val date: LocalDateTime = fullDateTime.plusSeconds(1_000_000_000)

    constructor(dateOnly: LocalDate) : this(dateOnly.atStartOfDay())
}
