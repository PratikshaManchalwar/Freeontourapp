package com.app.freeontour.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WayPoints (
    @SerializedName("id")
    val id : Long = 0,
    @SerializedName("address")
    val address : String = "",
    @SerializedName("city")
    val city : String = "",
    @SerializedName("country_id")
    val country_id : Int = 0,
     @SerializedName("name")
    val name : String = "",
    @SerializedName("description")
    val description : String? = "sample",
    val url : String = "",
    @SerializedName("type")
    val type : String = "",
    @SerializedName("distance")
    val distance : Long = 0,
    @SerializedName("duration")
    val duration : Long = 0
) : Serializable
