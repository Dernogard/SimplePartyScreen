package ru.dernogard.simplepartyscreen.data

import com.google.gson.Gson
import ru.dernogard.simplepartyscreen.model.Event

internal class DataParserFromJson: DataParser {

    private val gson: Gson = Gson()
    private val dataLoader: DataLoader = DataLoaderFromFileImpl()

    override fun parse(): Event? {
        val json = dataLoader.load()
        return gson.fromJson(json, Event::class.java)
    }

}