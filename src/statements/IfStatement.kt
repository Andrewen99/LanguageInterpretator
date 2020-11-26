package statements

import Program

class IfStatement : Statement() {
    override fun execute(program: Program) {
        var line = program.lines[program.currentLine]
        checkBrackets(program)
        line = line.substringAfter("if").trim()
        var boolExpression = getBoolExpression(line)
        program.ifFlag = boolExpression.calculate(program)
        program.ifPlot()


    }
}