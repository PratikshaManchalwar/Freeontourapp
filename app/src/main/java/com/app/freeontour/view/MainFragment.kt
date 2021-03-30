package com.app.freeontour.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.app.freeontour.R
import com.app.freeontour.adapter.ViewPagerAdapter
import com.app.freeontour.databinding.MainFragmentBinding
import com.app.freeontour.viewmodel.WayPointsRepository
import com.app.freeontour.viewmodel.WayPointsViewModel
import com.app.freeontour.viewmodel.WayPointsViewModelFactory
import com.freeontour.model.RouteData

class MainFragment : Fragment() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private lateinit var routeData: RouteData

    lateinit var mainFragmentBinding: MainFragmentBinding

    private lateinit var repository: WayPointsRepository

    private lateinit var viewModel: WayPointsViewModel

    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        return mainFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repository = WayPointsRepository(requireContext())

        viewModel = ViewModelProvider(this, WayPointsViewModelFactory(requireContext())).get(
            WayPointsViewModel::class.java
        )

        subscribe()

        mainFragmentBinding.sortOptions.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position > 0) {
                        when (parent?.getItemAtPosition(position)) {
                            "Newest" -> routeData.waypoints =
                                routeData.waypoints.sortedByDescending { it.id }
                            "Oldest" -> routeData.waypoints = routeData.waypoints.sortedBy { it.id }
                            "Waypoint Type" -> routeData.waypoints =
                                routeData.waypoints.sortedBy { it.type }
                            "Longest Duration" -> routeData.waypoints =
                                routeData.waypoints.sortedByDescending { it.duration }
                        }
                        mainFragmentBinding.viewPager.adapter = viewPagerAdapter
                    }
                }
            }

        mainFragmentBinding.backIcon.setOnClickListener {
            activity?.finish()
        }
    }

    private fun subscribe() {
        activity?.let {
            viewModel.fetchData().observe(it, Observer {

                routeData = it

                mainFragmentBinding.routeData = routeData

                viewPagerAdapter =
                    activity?.supportFragmentManager?.let { ViewPagerAdapter(it, 0) }!!
                viewPagerAdapter.setData(routeData)
                viewPager = mainFragmentBinding.viewPager
                mainFragmentBinding.viewPager.adapter = viewPagerAdapter
                mainFragmentBinding.tabLayout.setupWithViewPager(viewPager)
            })

        }

    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
