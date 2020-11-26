import java.io.File

object FileReader {
    fun parseFile(path: String): MutableList<String> {
        var result = mutableListOf<String>()
        File(path).forEachLine {
            result.add(it)
        }
        return result;
    }
}