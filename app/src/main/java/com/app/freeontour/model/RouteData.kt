package com.freeontour.model

import com.app.freeontour.model.User
import com.app.freeontour.model.WayPoints
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RouteData (
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("user")
    val user : User,
    @SerializedName("name")
    val name : String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("distance")
    val distance : Long = 0,
    @SerializedName("duration")
    val duration : Long = 0,
    @SerializedName("days")
    val days : Int = 0,
    @SerializedName("camping_count")
    val camping_count: Int = 0,
    @SerializedName("comments_count")
    val comments_count : Int = 0,
    @SerializedName("waypoint_count")
    val waypoint_count : Int = 0,
    @SerializedName("waypoints")
    var waypoints : List<WayPoints>
) : Serializable