import android.content.Context

object Utils {

    fun getJsonData(context: Context, fileName: String): String? {
        return context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    }
}