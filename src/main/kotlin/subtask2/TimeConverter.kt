package subtask2

class TimeConverter {
    private fun intToString(digits: Int): String {
        val fArray = arrayOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
        )
        val sArray = arrayOf(
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
        )
        var res = ""
        if (digits < 20) {
            res = fArray[digits]
        } else if (digits < 100) {
            val g = digits % 10
            val k = (digits - g) / 10
            res = if (g == 0) {
                sArray[k]
            } else {
                sArray[k] + " " + fArray[g]
            }
        }
        return res
    }

    fun toTextFormat(hour: String, minute: String): String {
        val hourInt = hour.toInt()
        val minutesInt = minute.toInt()
        var res = ""
        if (hourInt in 1..12 && minutesInt in 0..59) {
            when {
                minutesInt == 0 -> {
                    res = intToString(hourInt) + " o' clock"
                }
                minutesInt == 15 -> {
                    res = "quarter past " + intToString(hourInt)
                }
                minutesInt == 30 -> {
                    res = "half past " + intToString(hourInt)
                }
                minutesInt < 30 -> {
                    res = intToString(minutesInt) + " minutes past " + intToString(hourInt)
                }
                minutesInt == 45 -> {
                    res = "quarter to " + intToString(hourInt + 1)
                }
                minutesInt > 30 -> {
                    res = intToString(60 - minutesInt) + " minutes to " + intToString(hourInt + 1)
                }
            }
        }
        return res
    }
}