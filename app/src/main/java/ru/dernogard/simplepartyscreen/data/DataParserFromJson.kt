package ru.dernogard.simplepartyscreen.data

import com.google.gson.Gson
import ru.dernogard.simplepartyscreen.model.Event
import ru.dernogard.simplepartyscreen.utils.ErrorHandler
import ru.dernogard.simplepartyscreen.utils.ErrorHandlerToastImpl

/**
 * Parsing json-string with some Event using Gson
 */

internal class DataParserFromJson: DataParser {

    private val gson: Gson = Gson()
    private val dataLoader: DataLoader = DataLoaderFromFileImpl()
    private val errorHandler: ErrorHandler = ErrorHandlerToastImpl()

    override fun parse(): Event {
        val json = dataLoader.load()
        return try {
            gson.fromJson(json, Event::class.java)
        } catch (e: Exception) {
            errorHandler.handle(e)
            Event()
        }
    }

}