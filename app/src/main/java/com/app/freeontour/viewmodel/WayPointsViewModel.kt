package com.app.freeontour.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.freeontour.model.RouteData

class WayPointsViewModel(context: Context) : ViewModel() {

    private val routeData = MutableLiveData<RouteData>()
    private var repository: WayPointsRepository = WayPointsRepository(context)

    init {
        getData()
    }

    private fun getData() {
        val data = repository.getJsonData()

        routeData.postValue(data)
    }

    fun fetchData(): MutableLiveData<RouteData> {
        return routeData
    }
}