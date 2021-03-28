package com.app.freeontour.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.freeontour.view.Comments
import com.app.freeontour.view.MapFragment
import com.app.freeontour.view.WaypointsFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return WaypointsFragment()
            1 -> return MapFragment()
            2 -> return Comments()

        }
        return WaypointsFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }

}
