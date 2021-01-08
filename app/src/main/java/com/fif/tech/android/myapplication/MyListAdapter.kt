package com.fif.tech.android.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fif.tech.android.myapplication.databinding.ListItemsBinding
import com.fif.tech.android.myapplication.entities.People

/**
 * Created by JGarcia on 29-10-20.
 */
class MyListAdapter(private var list: List<People>): RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    fun update(list: List<People>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun loadView(item: People) {
            ListItemsBinding.bind(view).apply {
                txtFirst.text = item.name
                txtSecond.text = item.gender
            }
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