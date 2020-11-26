package expressions

import Program
import instrmnts.Calculator
import instrmnts.Operation
import instrmnts.Translator
import instruments.MyException
import statements.checkVarExist

class Expression(expr: String) {
    val value = expr.trim()
    var translator = Translator()
    var calculator = Calculator()

    fun calculate(program: Program): Int {
        var polskBackwards = translator.translate(value).toMutableList()
        var result = calculator.calculateExpression(checkPolsk(polskBackwards, program))

        result = result.replace("[", "")
        result = result.replace("]", "")
        return result.toDouble().toInt()
    }

    fun checkPolsk(polsk: MutableList<Operation>, program: Program):MutableList<Operation> {
       polsk.forEach {
           val symbol = it.operation[0]
           if (symbol.isLetter()) {
               if (checkVarExist(program,symbol )) {
                   it.operation = program.vars.get(symbol).toString()
               } else {
                   throw MyException(program, "Переменная $symbol не инициализирована")
               }
           }
       }
        return polsk

    }
}