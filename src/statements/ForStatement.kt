package statements

import Program
import expressions.Expression
import instruments.MyException

class ForStatement : Statement() {
    override fun execute(program: Program) {
        var line = program.lines[program.currentLine]
        checkBrackets(program)
        program.brackets.add('{')
        line = line.substringAfter("for").trim().replace("{", "")
        var variable = getVar(line)
        if (variable != null) {
            line = line.substringAfter("=").trim()
            var expression1 = Expression(line.substringBefore("to").trim())
            var expression2 = Expression(line.substringAfter("to").trim())
            program.currentLine++
            val startLineNum = program.currentLine

            for (i in expression1.calculate(program)..expression2.calculate(program)) {
                if (program.brackets.size == 0) {
                    program.brackets.add('{')
                }
                program.vars.put(variable, i)
                program.currentLine = startLineNum
                program.innerForProgram()
            }
            program.currentLine++
        } else {
            throw MyException(program, "Переменная не та")
        }

    }
}