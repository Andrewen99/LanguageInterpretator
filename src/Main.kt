import statements.StatementHelper

fun main() {
    val program = Program("files/code.txt")
    println(program)

    while (!program.isFinished()) {
        StatementHelper.defineAndExecStatement(program)
    }
}