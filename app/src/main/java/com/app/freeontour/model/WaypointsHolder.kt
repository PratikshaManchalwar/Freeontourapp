package com.app.freeontour.model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.freeontour.R
import com.ms.square.android.expandabletextview.ExpandableTextView

class WaypointsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val distanceInKm: TextView = itemView.findViewById(R.id.distance)
    private val numberOfDays: TextView = itemView.findViewById(R.id.numberofdays)
    private val waypointsCount: TextView = itemView.findViewById(R.id.waypoints)
    private val description: ExpandableTextView = itemView.findViewById(R.id.expand_text_view)
    private val displayName: TextView = itemView.findViewById(R.id.displayName)
    private val cityName: TextView = itemView.findViewById(R.id.cityName)
    private val addressDescription: ExpandableTextView = itemView.findViewById(R.id.addressDescription)

    fun updateData(
        distance: String,
        noOfDays: String,
        waypoints: String,
        desc: String,
        username: String,
        city: String,
        fullAddress: String
    ) {
        distanceInKm.text = distance + " " + "kilometers"
        numberOfDays.text = noOfDays + " " + "days"
        waypointsCount.text = waypoints + " " + "waypoints"
        description.text = desc
        displayName.text = username
        cityName.text = city
        addressDescription.text = fullAddress
    }
}