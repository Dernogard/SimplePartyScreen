package ru.dernogard.simplepartyscreen.model

import com.google.gson.annotations.SerializedName

/**
 * Default values are using for checking
 * {@link EventFragment#setupObservables()}
 * so if change their here don't forget to change there
 */

internal data class User (
    @SerializedName("name") val name: String = "",
    @SerializedName ("avatarUrl") val avatarUrl: String = ""
)