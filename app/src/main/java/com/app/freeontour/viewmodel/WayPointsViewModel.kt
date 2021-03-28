package com.app.freeontour.viewmodel

import Utils
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WayPointsViewModel(private val context: Context) : ViewModel() {

    private var wayPointData = MutableLiveData<String>()

    fun getData(): LiveData<String>? {
        wayPointData.value = Utils.getJsonData(context, "Route.json")
        return wayPointData
    }
}