package subtask6

class Fibonacci {
    private fun getNextFibonacci(n: Int, n1: Int): Int {
        return n + n1
    }

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val fibo = mutableListOf(0, 1)
        while (fibo[fibo.count() - 2] * fibo[fibo.count() - 1] < n) {
            val next = getNextFibonacci(fibo[fibo.count() - 2], fibo[fibo.count() - 1])
            fibo.add(next)
        }
        val res = mutableListOf(fibo[fibo.count() - 2], fibo[fibo.count() - 1])
        if (fibo[fibo.count() - 2] * fibo[fibo.count() - 1] == n) {
            res.add(1)
        } else {
            res.add(0)
        }
        return res.toIntArray()
    }
}
