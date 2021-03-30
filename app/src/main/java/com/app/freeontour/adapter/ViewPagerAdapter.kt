package com.app.freeontour.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.freeontour.view.CommentsFragment
import com.app.freeontour.view.MapFragment
import com.app.freeontour.view.WaypointsFragment
import com.freeontour.model.RouteData

class ViewPagerAdapter(supportFragmentManager: FragmentManager,
    behavior: Int
) : FragmentPagerAdapter(supportFragmentManager, behavior) {

    private val waypoints = 0
    private val map = 1
    private val comments = 2

    private val tabs = intArrayOf(waypoints, map, comments)

    private lateinit var routeData: RouteData

    override fun getItem(position: Int): Fragment {
        when (tabs[position]) {
            0 -> {
                val fragment: WaypointsFragment = WaypointsFragment.newInstance()
                val b = Bundle()
                b.putSerializable("routeData", routeData)
                fragment.arguments = b
                return fragment
            }
            1 -> return MapFragment()
            2 -> return CommentsFragment()
        }
        return WaypointsFragment.newInstance()
    }


    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (tabs[position]) {
            waypoints -> return "WayPoints"
            map -> return "Map"
            comments -> return routeData.comments_count.toString() + " Comments"
        }
        return null
    }

    fun setData(data: RouteData) {
        this.routeData = data
    }

}
