package subtask4

class Pangram {
    private val vowels: List<Char> = listOf('a', 'e', 'i', 'o', 'u', 'y')

    private fun transformer(isPangram: Boolean, input: String): Pair<Int, String> {
        var res = 0
        var prepared = ""
        for (i in input.indices) {
            if ((isPangram && vowels.contains(input[i]))
                || (!isPangram && !vowels.contains(input[i].toLowerCase()) && input[i].toLowerCase() in 'a'..'z')
            ) {
                res++
                prepared += input[i].toUpperCase().toString()
            } else {
                prepared += input[i].toString()
            }
        }
        return Pair(res, res.toString() + prepared)
    }

    fun getResult(inputString: String): String {
        var count = 0
        var char = 'A'
        while (char <= 'Z') {
            if (inputString.contains(char, true)) {
                count++
            }
            ++char
        }
        val isPangram = count == 26
        val regex = Regex("\\s{2,}+")
        val words = inputString.replace(regex, " ").split(' ').filter { it.isNotEmpty() }
        val transformedWords = mutableListOf<Pair<Int, String>>()
        for (i in words.indices) {
            transformedWords.add(transformer(isPangram, words[i]))
        }
        transformedWords.sortBy { it.first }
        val result = transformedWords.joinToString(" ") { it.second }
        return result
    }
}