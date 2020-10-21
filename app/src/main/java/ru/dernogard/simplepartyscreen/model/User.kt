package ru.dernogard.simplepartyscreen.model

import com.google.gson.annotations.SerializedName

internal data class User (
    @SerializedName("name") val name: String = "",
    @SerializedName ("avatarUrl") val avatarUrl: String = ""
)