package com.app.freeontour.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.app.freeontour.R
import com.app.freeontour.model.WayPoints

class WayPointsAdapter(private val itemsCells: List<WayPoints>) :
    RecyclerView.Adapter<WayPointsAdapter.ViewHolder>() {

     private lateinit var context: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.waypoints_data, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsCells.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val wayPoints: WayPoints = itemsCells[position]

        val place = holder.itemView.findViewById<TextView>(R.id.place)
        val address = holder.itemView.findViewById<TextView>(R.id.address)
        val description = holder.itemView.findViewById<TextView>(R.id.description)
        val distance = holder.itemView.findViewById<TextView>(R.id.distance)
        val duration = holder.itemView.findViewById<TextView>(R.id.duration)

        distance.text = context.getString(R.string.distance, wayPoints.distance / 1000)
        duration.text = context.getString(R.string.duration, wayPoints.duration / 3600)

        place.text = wayPoints.name
        address.text = wayPoints.address
        val data = wayPoints.description
        description.text = data

    }

}