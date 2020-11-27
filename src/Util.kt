package statements

import Program
import expressions.BoolExpression
import expressions.Expression
import instruments.MyException

fun checkSemiColon(line: String, program: Program) {
    if (!line.trim().endsWith(";")) {
        throw MyException(program, "Отсутсвует ';'" )
    }
}

fun checkBrackets(program: Program) {
    if (!program.lines[program.currentLine].contains("{") &&
            !program.lines[program.currentLine + 1].contains("{")) {
        throw MyException(program, "Отсутсвует '{'" )
    }
}

fun getBoolExpression(expression: String): BoolExpression {
    var operation = ""
    when {
        expression.contains("<") -> operation = "<"
        expression.contains(">") -> operation = ">"
        expression.contains("==") -> operation = "=="
        expression.contains("!=") -> operation = "!="
    }
    var expression1 = Expression(expression.substringBefore(operation))
    var expression2 = Expression(expression.substringAfter(operation))

    return BoolExpression(expression1, expression2, operation)
}

fun checkVarExist(program: Program, variable: Char): Boolean {
    return program.vars.containsKey(variable)
}

fun getVar(line: String): Char? {
    var variable = line.split("=")[0].trim()
    if (variable.length == 1) {
        return variable[0]
    }
    return null
}

