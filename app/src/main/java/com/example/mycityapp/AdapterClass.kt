package com.example.mycityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<DataClass>): RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val dataItem =  dataList[position]
        holder.rvImage.setImageResource(dataItem.dataImage)
        holder.rvContentText.text = dataItem.dataText

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("imageResId", dataItem.dataImage)
                putString("description", dataItem.dataDesc)
            }
            it.findNavController().navigate(R.id.action_categoryOneFragment_to_detailsFragment, bundle)
        }

    }

    class ViewHolderClass(itemView:     View): RecyclerView.ViewHolder(itemView){
        val rvImage: ImageView = itemView.findViewById(R.id.cardImage)
        val rvContentText: TextView = itemView.findViewById(R.id.contentText)
    }

}