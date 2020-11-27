package statements

import Program


object StatementHelper {
    val statements = mutableMapOf<String, Statement>("assign" to Assign(), "print" to Print(),
            "scan" to Scan(), "if" to IfStatement(), "for" to ForStatement())

    fun defineAndExecStatement(program: Program) {
        var line = program.lines[program.currentLine]
        var parts = line.trim().split("\\s+".toRegex())

        when  {
            (parts[0].length == 1 && parts[0][0].isLetter()) -> statements.get("assign")?.execute(program)
            parts[0] == "print" -> statements.get("print")?.execute(program)
            parts[0] == "scan" -> statements.get("scan")?.execute(program)
            parts[0] == "if" -> statements.get("if")?.execute(program)
            parts[0] == "for" -> statements.get("for")?.execute(program)
        }
    }
}