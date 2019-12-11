fun Int.divisibleBy(other: Int): Boolean {
    return (this % other) == 0
}

fun Int.fizzBuzzOrItself(): String {
    if (this <= 0) throw IllegalArgumentException("FizzBuzz argument must be positive.")
    return when (true) {
        this.divisibleBy(3 * 5) -> "FizzBuzz"
        this.divisibleBy(3) -> "Fizz"
        this.divisibleBy(5) -> "Buzz"
        else -> this.toString()
    }
}

fun printFizzBuzz(range: IntRange) {
    range
        .map { it.fizzBuzzOrItself() }
        .forEach { println(it) }
}

fun printFizzBuzz(max: Int) = printFizzBuzz(1..max)

fun commonMain(max: Int = 20) = printFizzBuzz(max)