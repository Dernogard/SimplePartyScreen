package ru.dernogard.simplepartyscreen.data

import ru.dernogard.simplepartyscreen.model.Event

internal interface DataParser {

    fun parse(): Event?

}