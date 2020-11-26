import instruments.MyException
import statements.StatementHelper

class Program(codePath: String) {
    val lines = FileReader.parseFile(codePath)
    var vars = hashMapOf<Char, Int>()
    var brackets = mutableListOf<Char>()
    var ifFlag = false

    var currentLine = 0

    fun isFinished(): Boolean {
        return lines.lastIndex < currentLine
    }

    fun ifPlot() {
        if (lines[currentLine].contains("{")) {
            brackets.add('{')
            currentLine++
        }
        else {
            currentLine++
            if (lines[currentLine].contains("{")) {
                brackets.add('{')
                currentLine++
            } else {
                throw MyException(this, "Где '{' а?")
            }
        }

        while (brackets.size > 0 && !isFinished()) {
            findBrackets()
            if (brackets.size > 0 && !isFinished()) {
                if (ifFlag) {
                    StatementHelper.defineAndExecStatement(this)
                } else {
                    currentLine++
                }
            }
        }
        ifFlag = false
    }

    fun findBrackets() {
        if (lines[currentLine].contains("{")) {
            brackets.add('{')
            currentLine++
        }
        if (lines[currentLine].contains("}")) {
            brackets.removeAt(brackets.lastIndex)
            currentLine++
        }
    }


}