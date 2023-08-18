package com.yasin.behaviourdemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout

class CustomAppBarBehavior(context: Context, attrs: AttributeSet) : AppBarLayout.Behavior(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: AppBarLayout, dependency: View): Boolean {
        // Specify which views should affect the behavior
        return dependency is ConstraintLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, appBarLayout: AppBarLayout, dependency: View): Boolean {
        val dependentView = dependency as ConstraintLayout

        dependentView.translationY = appBarLayout.bottom.toFloat()
        return super.onDependentViewChanged(parent, appBarLayout, dependency)
    }
}