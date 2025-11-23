
package ie.tudublin

import java.io.File

fun main(args: Array<String>) {
    val fileName = args.getOrNull(0)
    if (fileName == null) {
        println("Please provide the input file name as a command-line argument.")
        return
    }

    val rows = try {
        File(fileName).readLines()
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        return
    }

    if (rows.size != 9 || rows.any { it.length != 9 }) {
        println("Invalid board! The board must be 9x9.")
        return
    }

    println("Input board:")
    rows.forEach { println(it) }

    val sudoku = Sudoku(rows)
    sudoku.solve()

    if (sudoku.isSolved()) {
        println("\nSolved board:")
        println(sudoku)
    } else {
        println("\nCould not find a solution!")
    }
}

