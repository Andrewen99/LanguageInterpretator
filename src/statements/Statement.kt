package statements

import Program

abstract class Statement {
    abstract fun execute(program: Program)

}