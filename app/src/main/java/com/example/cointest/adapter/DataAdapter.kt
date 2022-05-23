package com.example.cointest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cointest.R
import com.example.cointest.models.DataModel
import java.text.SimpleDateFormat


class DataAdapter(var dataModels: List<DataModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.coin_item,null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = dataModels.get(position)
        val item_time = holder.itemView.findViewById<TextView>(R.id.item_Time)
        val item_price = holder.itemView.findViewById<TextView>(R.id.item_Price)
        val item_count = holder.itemView.findViewById<TextView>(R.id.item_Count)


        item_time.text = transToString(model.time)
        item_price.text = model.price
        item_count.text = model.volume

    }

    override fun getItemCount(): Int {
        return dataModels.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    fun transToString(time: Long):String {
        return SimpleDateFormat("hh:mm:ss").format(time)
    }


}