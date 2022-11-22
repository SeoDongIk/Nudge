package com.example.nudge

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nudge.Entity.PlayerEntity
import com.example.nudge.Entity.SquadEntity


class SelectRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<SelectRecyclerViewAdapter.ViewHolder>() {

    private var items = mutableListOf<PlayerEntity>()

    fun setPlayerList(data:MutableList<PlayerEntity>){
        items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.selectitem,parent,false)
        return ViewHolder(view)
    }

    interface ItemClick{
        fun onClick(view: View, item : PlayerEntity)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: SelectRecyclerViewAdapter.ViewHolder, position: Int) {
        if(itemClick != null){
            holder.itemView.setOnClickListener{
                itemClick?.onClick(it, items[position])
            }
        }
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : PlayerEntity){
            itemView.findViewById<TextView>(R.id.name).setText(item.name)
        }
    }

}