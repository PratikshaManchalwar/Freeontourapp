package com.app.freeontour.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.freeontour.R
import com.app.freeontour.adapter.WayPointsAdapter
import com.app.freeontour.databinding.WaypointsFragmentBinding
import com.freeontour.model.RouteData

class WaypointsFragment : Fragment() {

    lateinit var routeData: RouteData

    private lateinit var adapter: WayPointsAdapter

    private lateinit var binding: WaypointsFragmentBinding

    private var expandableSize = ArrayList<Int>()

    private var isCollapse: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.waypoints_fragment, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        routeData = arguments?.get("routeData") as RouteData

        binding.routeData = routeData

        recyclerviewCellSize()

        binding.waypointsRecyclerview.layoutManager = LinearLayoutManager(activity)

        binding.waypointsRecyclerview.addItemDecoration(
            DividerItemDecoration(
                binding.waypointsRecyclerview.context,
                (binding.waypointsRecyclerview.layoutManager as LinearLayoutManager).orientation
            )
        )

        adapter = WayPointsAdapter(routeData.waypoints)
        binding.waypointsRecyclerview.adapter = adapter

        binding.expandCollapse.setOnClickListener {
            if (isCollapse) {
                binding.expandableText.maxLines = Integer.MAX_VALUE
                binding.expandCollapse.setImageResource(R.mipmap.up_arrow)
                isCollapse = false
            } else {
                binding.expandableText.maxLines = 2
                binding.expandCollapse.setImageResource(R.mipmap.down_arrow)
                isCollapse = true
            }
        }
    }

    private fun recyclerviewCellSize() {
        expandableSize = ArrayList()
        for (i in 0 until routeData.waypoints.count()) {
            expandableSize.add(0)
        }
    }

    companion object {
        fun newInstance() = WaypointsFragment()
    }

}
