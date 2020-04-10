package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*


class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu")
            .withResolverStyle(ResolverStyle.STRICT)
        val outputFormatter = DateTimeFormatter.ofPattern("d MMMM, EEEE")
            .withLocale(Locale.forLanguageTag("ru-RU"))
        val stringDate = "${day.padStart(2, '0')}-${month.padStart(2, '0')}-${year.padStart(4, '0')}"
        try {
            val date = LocalDate.parse(stringDate, inputFormatter)
            val result = date.format(outputFormatter)
            return result
        } catch (e: Exception) {
            return "Такого дня не существует"
        }
    }
}
