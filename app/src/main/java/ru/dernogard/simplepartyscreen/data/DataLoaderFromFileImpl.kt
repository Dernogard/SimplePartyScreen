package ru.dernogard.simplepartyscreen.data

import androidx.annotation.RawRes
import ru.dernogard.simplepartyscreen.App
import ru.dernogard.simplepartyscreen.R
import ru.dernogard.simplepartyscreen.utils.ErrorHandler
import ru.dernogard.simplepartyscreen.utils.ErrorHandlerToastImpl
import java.lang.Exception

/**
 * Loading json from file kept in the apk
 */

internal class DataLoaderFromFileImpl : DataLoader {

    @RawRes
    private val fileName: Int = R.raw.event

    private val errorHandler: ErrorHandler = ErrorHandlerToastImpl()

    override fun load(): String {
        return try {
            val inputStream  = App.context.resources.openRawResource(fileName)
            val bufferedReader  = inputStream.bufferedReader()
            bufferedReader.use { it.readText() }
        } catch (e: Exception) {
            errorHandler.handle(e)
            "{}"
        }
        
    }

}