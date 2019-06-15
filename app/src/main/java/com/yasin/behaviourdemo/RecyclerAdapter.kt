package com.yasin.behaviourdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
    }


    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}