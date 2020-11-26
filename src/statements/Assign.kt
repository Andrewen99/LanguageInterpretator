package statements

import expressions.Expression
import Program
import instruments.MyException
import java.lang.RuntimeException

class Assign : Statement() {
    override fun execute(program: Program) {
        val line = program.lines[program.currentLine]
        val variable = getVar(line)
        if (variable != null) {
            val expression = Expression(line.substringAfter("=").trim())
            var value = expression.calculate(program)
            program.vars.put(variable, value)
            program.currentLine++
        } else {
            throw MyException(program, "")
        }

    }

    fun getVar(line: String): Char? {
        var variable = line.split("=")[0].trim()
        if (variable.length == 1) {
            return variable[0]
        }
        return null
    }

    fun getExpression(line: String): Expression {
        var expString = line.split("=")[1].trim()
        return Expression(expString)
    }

}