package com.app.freeontour.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
    @SerializedName("id")
    val id : Long = 0,
    @SerializedName("username")
    val username : String = "",
    @SerializedName("displayname")
    val displayname : String = ""
) : Serializable
