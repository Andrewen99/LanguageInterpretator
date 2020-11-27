import statements.StatementHelper

fun main() {
    val program = Program("files/code1.txt")
    println(program)

    while (!program.isFinished()) {
        StatementHelper.defineAndExecStatement(program)
    }
}