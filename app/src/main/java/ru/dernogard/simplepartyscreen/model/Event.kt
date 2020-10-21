package ru.dernogard.simplepartyscreen.model

import com.google.gson.annotations.SerializedName

internal data class Event(
    @SerializedName("title") val title: String = "",
    @SerializedName("logo") val logoUrl: String = "",
    @SerializedName("host") val host: User,
    @SerializedName("guests") val guests: List<User>
)