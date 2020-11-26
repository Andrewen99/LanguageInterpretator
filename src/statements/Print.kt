package statements

import Program
import expressions.Expression

class Print: Statement() {
    override fun execute(program: Program) {
       var line = program.lines[program.currentLine]
        checkSemiColon(line, program)
        line = line.substringAfter("print").replace(";", "")
//        if (!printLine.endsWith(";")) {
//            program.currentLine++
//            printLine += program.lines[program.currentLine]
//        }
        var expressions = line.split(",")
        var printResult = ""
        for (expression: String in expressions) {
            printResult += expToText(expression.trim(), program)
        }

        println(printResult)
        program.currentLine++
    }

    fun expToText(expression: String, program: Program): String {
        if (expression.startsWith("\"") && expression.endsWith("\"")) {
            return expression.substring(1, expression.lastIndex)
        } else {
            return Expression(expression).calculate(program).toString()
        }
//        else if (expression[0].isLetter() && program.vars.containsKey(expression.trim()[0])) {
//            val result = "" + program.vars.get(expression[0])
//            return result
//        }
        return "bad"
    }
}