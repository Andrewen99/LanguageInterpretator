package statements

import Program
import instruments.MyException
import java.lang.RuntimeException
import java.util.*

class Scan: Statement() {
    override fun execute(program: Program) {
        var line = program.lines[program.currentLine]
        checkSemiColon(line, program)
        var variable = line.substringAfter("scan").replace(";", "").trim()

        if (variable.length > 1 || !variable[0].isLetter()) {
            throw MyException(program,
                            "Длина названия переменной не должна превышать 1 символа и должна являться символом англ алфавита"
            )
        } else {
            program.vars.put(variable[0], intFromConsole() ?: 0)
        }

        program.currentLine++
    }

    fun intFromConsole(): Int? {
        val input = Scanner(System.`in`)
        val a = input.nextInt()
        return a
    }
}