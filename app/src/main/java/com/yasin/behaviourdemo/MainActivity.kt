package com.yasin.behaviourdemo

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_appbar_second_view.*

class MainActivity : AppCompatActivity(), ChipGroup.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        applyWindowInsets()
        nav_chips.setOnCheckedChangeListener(this)
        chip_car.isChecked = true
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycler.adapter = RecyclerAdapter()
    }

    private fun applyWindowInsets() {
        coordinator.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)

        coordinator.setOnApplyWindowInsetsListener { view, windowInsets ->

            val lpActionBar = appBar?.layoutParams as ViewGroup.MarginLayoutParams
            lpActionBar.topMargin += windowInsets.systemWindowInsetTop
            appBar.layoutParams = lpActionBar

            val lpRecycler = recycler?.layoutParams as ViewGroup.MarginLayoutParams
            lpRecycler.bottomMargin += windowInsets.systemWindowInsetBottom
            recycler.layoutParams = lpRecycler

            // clear this listener so insets aren't re-applied
            coordinator.setOnApplyWindowInsetsListener(null)
            windowInsets.consumeSystemWindowInsets()
        }
    }



    override fun onCheckedChanged(p0: ChipGroup?, p1: Int) {
        when(p1){
            R.id.chip_car -> {
                nav_chips.checkedChipId
            }
            R.id.chip_bus -> {

            }
            R.id.chip_walk -> {

            }
            R.id.chip_rail ->{

            }
        }
    }
}
