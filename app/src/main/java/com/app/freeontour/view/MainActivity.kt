package com.app.freeontour.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.app.freeontour.R
import com.app.freeontour.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var adapter: ViewPagerAdapter? = null

    private var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
          finish()
        }

        adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager = findViewById<ViewPager?>(R.id.viewpager)
        viewPager!!.adapter = adapter

        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setText("Waypoint")
        tabLayout.getTabAt(1)!!.setText("Map")
        tabLayout.getTabAt(2)!!.setText("Comments")
    }
}