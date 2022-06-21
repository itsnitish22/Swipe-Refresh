package com.example.swipe_refresh.pulltorefresh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swipe_refresh.R

class NumbersRecyclerViewAdapter(private val numbers: MutableList<Int>) :
    RecyclerView.Adapter<NumbersRecyclerViewAdapter.ViewHolder>() {

    //on createViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumbersRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    //binding the view with data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.number.text = numbers[position].toString()
    }

    //item count
    override fun getItemCount(): Int {
        return numbers.size
    }

    //viewHolder class for defining the elements of view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number: TextView = itemView.findViewById(R.id.numbers)
    }
}