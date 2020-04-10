package subtask3

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        var source = a.toUpperCase()
        for (i in b.indices) {
            while (i < source.length) {
                if (source[i] != b[i]) {
                    source = source.substring(0, i) + source.substring(i + 1, source.length)
                } else {
                    break;
                }
            }
        }
        if (source.length > b.length) {
            source = source.substring(0, b.length);
        }
        if (source == b) {
            return "YES";
        }
        return "NO";
    }
}
