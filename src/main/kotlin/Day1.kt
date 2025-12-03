package pl.kondziet

import java.io.File

fun main() {
    println(
        """
        day 1
        part 1: ${part1()}
        """
    )
}

fun part1(): Int {
    val lines = File("src/main/resources/day1-p1.txt").readLines()

    return lines.asSequence()
        .map { rotation ->
            val direction = rotation[0]
            val clicks = rotation.substring(1).toInt()
            if (direction == 'L') -clicks else clicks
        }
        .runningFold(50) { currentPosition, turn ->
            (currentPosition + turn).mod(100)
        }
        .drop(1)
        .count { it == 0 }
}