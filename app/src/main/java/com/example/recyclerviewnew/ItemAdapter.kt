package com.example.recyclerviewnew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewnew.databinding.ItemBinding

class ItemAdapter : ListAdapter<Items, ItemAdapter.ItemViewHolder>(ItemDiffCallBack()) {
    var onItemClickListener: ((Items) -> Unit)? = null
    class ItemViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.tvCount.text = currentItem.id.toString()
        holder.binding.tvName.text = currentItem.name
        holder.binding.root.setOnClickListener{
            onItemClickListener?.invoke(currentItem)
        }
    }


}