package ru.dernogard.simplepartyscreen.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dernogard.simplepartyscreen.data.DataParser
import ru.dernogard.simplepartyscreen.data.DataParserFromJson
import ru.dernogard.simplepartyscreen.model.Event

internal class EventViewModel : ViewModel() {

    val eventLive = MutableLiveData<Event?>(null)

    private val dataParser: DataParser = DataParserFromJson()

    fun loadData() {
        val event = dataParser.parse()
        if (event != null) {
            eventLive.postValue(event)
        } else {
            Log.e(javaClass.simpleName, "Ошибка")
        }
    }



}