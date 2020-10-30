package com.fif.tech.android.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by JGarcia on 29-10-20.
 */
class MyListAdapter(private val list: List<Any>): RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun loadView(item: Any) {
            // TODO: cargar los valores del item en la lista
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.loadView(list[position])
    }

    override fun getItemCount(): Int = list.size

}