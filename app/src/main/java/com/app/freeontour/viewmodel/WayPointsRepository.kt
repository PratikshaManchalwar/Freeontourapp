package com.app.freeontour.viewmodel

import Utils
import android.content.Context
import com.freeontour.model.RouteData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WayPointsRepository(private val context: Context) {

    fun getJsonData(): RouteData {
        val jsonData = Utils.getJsonData(context, "Route.json")
        val routeType = object : TypeToken<RouteData>() {}.type
        val gson = Gson()
        return gson.fromJson(jsonData, routeType)
    }
}