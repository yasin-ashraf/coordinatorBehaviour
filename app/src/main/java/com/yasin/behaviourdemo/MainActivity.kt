package com.yasin.behaviourdemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
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
        nav_chips.setOnCheckedChangeListener(this)
        chip_car.isChecked = true
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
