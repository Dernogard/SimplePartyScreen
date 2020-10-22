package ru.dernogard.simplepartyscreen.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dernogard.simplepartyscreen.data.DataParser
import ru.dernogard.simplepartyscreen.data.DataParserFromJson
import ru.dernogard.simplepartyscreen.model.Event

/**
 * ViewModel for
 * @see EventFragment screen
 */

internal class EventViewModel : ViewModel() {

    private val dataParser: DataParser = DataParserFromJson()

    val eventLive: MutableLiveData<Event> = MutableLiveData(loadEvent())

    /**
     * @see DataParser should return Event from any storage
     */
    private fun loadEvent(): Event = dataParser.parse()

}