package ru.dernogard.simplepartyscreen.data

/**
 * Classes of this interface should return a json string
 */

internal interface DataLoader {

    fun load(): String

}