package com.yasin.behaviourdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.ChipGroup
import com.yasin.behaviourdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ChipGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        applyWindowInsets()
        binding.secondView.navChips.setOnCheckedChangeListener(this)
        binding.secondView.chipCar.isChecked = true
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter = RecyclerAdapter()
    }

    private fun applyWindowInsets() {
        binding.coordinator.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)

        binding.coordinator.setOnApplyWindowInsetsListener { view, windowInsets ->

            val lpActionBar = binding.appBar.layoutParams as ViewGroup.MarginLayoutParams
            lpActionBar.topMargin += windowInsets.systemWindowInsetTop
            binding.appBar.layoutParams = lpActionBar

            val lpRecycler = binding.recycler.layoutParams as ViewGroup.MarginLayoutParams
            lpRecycler.bottomMargin += windowInsets.systemWindowInsetBottom
            binding.recycler.layoutParams = lpRecycler

            // clear this listener so insets aren't re-applied
            binding.coordinator.setOnApplyWindowInsetsListener(null)
            windowInsets.consumeSystemWindowInsets()
        }
    }

    override fun onCheckedChanged(group: ChipGroup, checkedId: Int) {
        when(checkedId){
            R.id.chip_car -> {
                binding.secondView.navChips.checkedChipId
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
