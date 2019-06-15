package com.yasin.behaviourdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.google.android.material.chip.ChipGroup

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

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
    }

    private fun applyWindowInsets() {
        coordinator.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)

        coordinator.setOnApplyWindowInsetsListener { view, windowInsets ->

            val lpActionBar = appBar?.layoutParams as ViewGroup.MarginLayoutParams
            lpActionBar.topMargin += windowInsets.systemWindowInsetTop
            lpActionBar.leftMargin += windowInsets.systemWindowInsetLeft
            lpActionBar.rightMargin += windowInsets.systemWindowInsetRight
            appBar.layoutParams = lpActionBar

            /*val lpBottomNavigation = bottom_navigation?.layoutParams as ViewGroup.MarginLayoutParams
            lpBottomNavigation.bottomMargin += windowInsets.systemWindowInsetBottom
            lpBottomNavigation.leftMargin += windowInsets.systemWindowInsetLeft
            lpBottomNavigation.rightMargin += windowInsets.systemWindowInsetRight
            bottom_navigation.layoutParams = lpBottomNavigation

            val lpViewPagerIndicator = committee_card_indicator?.layoutParams as ViewGroup.MarginLayoutParams
            lpViewPagerIndicator.bottomMargin = lpViewPagerIndicator.bottomMargin + windowInsets.systemWindowInsetBottom + lpBottomNavigation.bottomMargin + bottom_navigation.height
            committee_card_indicator.layoutParams = lpViewPagerIndicator*/

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
