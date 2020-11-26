package instruments

import Program
import java.lang.RuntimeException

class MyException(program: Program, message: String):
        RuntimeException("Ошибка в строке ${program.currentLine}: ${program.lines[program.currentLine]}\n" + message)