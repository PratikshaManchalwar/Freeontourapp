package com.app.freeontour.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.freeontour.R
import com.app.freeontour.adapter.WayPointsAdapter
import com.app.freeontour.viewmodel.WayPointsViewModel
import com.app.freeontour.viewmodel.WayPointsViewModelFactory
import org.json.JSONException
import org.json.JSONObject

class WaypointsFragment : Fragment() {

    private lateinit var wayPointsViewModel: WayPointsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.waypoints_fragment, container, false)
        val waypointsRecyclerview = root.findViewById(R.id.waypointsRecyclerview) as RecyclerView

        wayPointsViewModel =
            ViewModelProvider(this, WayPointsViewModelFactory(requireContext())).get(
                WayPointsViewModel::class.java
            )

        try {
            wayPointsViewModel.getData()!!.observe(this, Observer {
                val jsonObject = JSONObject(it)

                val distance = jsonObject.optString("distance")
                val noOfDays = jsonObject.optString("days")
                val wayPointsCount = jsonObject.optString("waypoint_count")
                val description = jsonObject.optString("description")

                val userArray = jsonObject.getJSONObject("user")
                val displayName = userArray.getString("displayname")

                val waypointsArray = jsonObject.getJSONArray("waypoints")
                var fullAddress = ""
                var addressDescription = ""

                for (i in 0 until waypointsArray.length()) {
                    val jsonObj = waypointsArray.getJSONObject(i)
                    val address = jsonObj.optString("address")
                    val addDescription = jsonObj.optString("description")

                    fullAddress = address
                    addressDescription = addDescription
                }

                waypointsRecyclerview.adapter = WayPointsAdapter(
                    distance,
                    noOfDays,
                    wayPointsCount,
                    description,
                    displayName,
                    fullAddress,
                    addressDescription
                )
                waypointsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
            })

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return root
    }
}


