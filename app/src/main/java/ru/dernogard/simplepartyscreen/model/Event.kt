package ru.dernogard.simplepartyscreen.model

import com.google.gson.annotations.SerializedName

/**
 * Default values are using for checking
 * {@link EventFragment#setupObservables()}
 * so if change their here don't forget to change there
 */

internal data class Event(
    @SerializedName("title") val title: String = "",
    @SerializedName("logo") val logoUrl: String = "",
    @SerializedName("host") val host: User = User(),
    @SerializedName("guests") val guests: List<User> = emptyList()
)