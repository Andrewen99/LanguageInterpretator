package expressions

import Program
import instruments.MyException

class BoolExpression(arg1: Expression, arg2: Expression, operation: String) {
    val arg1 = arg1
    val arg2 = arg2
    val operation = operation

    fun calculate(program: Program): Boolean {
        var res1 = arg1.calculate(program)
        var res2 = arg2.calculate(program)
        when (operation) {
            ">" -> return res1 > res2
            "<" -> return res1 < res2
            "==" -> return res1 == res2
            "!=" -> return res1 != res2
        }
        throw MyException(program, "Something went wrong")
        return false
    }
}