package ru.dernogard.simplepartyscreen.data

import ru.dernogard.simplepartyscreen.model.Event

/**
 * Classes of this interface should return Event
 */

internal interface DataParser {

    fun parse(): Event

}