package ru.dernogard.simplepartyscreen.data

import androidx.annotation.RawRes
import ru.dernogard.simplepartyscreen.App
import ru.dernogard.simplepartyscreen.R

internal class DataLoaderFromFileImpl : DataLoader {

    @RawRes
    private val fileName: Int = R.raw.event

    override fun load(): String {
        val inputStream  = App.context.resources.openRawResource(fileName)
        val bufferedReader  = inputStream.bufferedReader()
        return bufferedReader.use { it.readText() }
    }

}