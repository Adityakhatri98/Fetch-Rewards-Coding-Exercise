package com.example.fetchrewardscodingexercise.features.rewardsdetails

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.network.model.RewardsListItem

interface OnItemValueChangedListener {
    fun onItemValueChanged(newValue: String)
}
class RewardsDetailsAdapter(private val listener: OnItemValueChangedListener): RecyclerView.Adapter<RewardsDetailsViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<RewardsListItem>(){
        override fun areItemsTheSame(oldItem: RewardsListItem, newItem: RewardsListItem): Boolean {
            Log.d("@#$@","y")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RewardsListItem, newItem: RewardsListItem): Boolean {
            Log.d("@#$@","y1")
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffCallback)
    var llls = "0"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsDetailsViewHolder {
        Log.d("@#$@","ocvh adpaertr")
        return RewardsDetailsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rewards_detail,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RewardsDetailsViewHolder, position: Int) {
        val currentList = differ.currentList[position]
        Log.d("@#$@","eee $currentList")
        with(holder.itemView) {
//            llls = currentList.listId.toString()
            findViewById<TextView>(R.id.reward_id).text = currentList.id.toString()
            findViewById<TextView>(R.id.list_id).text = currentList.listId.toString()
            findViewById<TextView>(R.id.name).text = currentList.name

            listener.onItemValueChanged(currentList.listId.toString())

        }
    }
}

class RewardsDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)