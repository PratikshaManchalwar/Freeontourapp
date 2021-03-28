package com.app.freeontour.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView
import com.app.freeontour.R
import com.app.freeontour.model.WaypointsHolder

class WayPointsAdapter(
    private val distance: String,
    private val noOfDays: String,
    private val waypoint: String,
    private val description: String,
    private val name: String,
    private val city: String,
    private val address: String
) : RecyclerView.Adapter<WaypointsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaypointsHolder {
        val waypointsItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.waypoints_data, parent, false) as ScrollView

        return WaypointsHolder(waypointsItem)
    }

    override fun onBindViewHolder(holder: WaypointsHolder, position: Int) {
        holder.updateData(distance, noOfDays, waypoint, description, name, city, address)
    }

    override fun getItemCount(): Int {
        return 1
    }

}
