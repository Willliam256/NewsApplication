package com.example.newsapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.Data
import com.example.newsapplication.R

class NewsCustomAdapter(private val arrayList:ArrayList<Data>): RecyclerView.Adapter<NewsCustomAdapter.CustomViewHolder>() {
    private lateinit var myListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.row_item_news,parent,false)

        return CustomViewHolder(layoutInflater, myListener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currItem = arrayList[position]
        holder.newsTitle.text = currItem.titleNews
        holder.newsImage.setImageResource(currItem.imageNews)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    //defining the view holder inside the custom adapter
    class CustomViewHolder(itemView:View, listener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        val newsTitle:TextView = itemView.findViewById(R.id.news_title)
        val newsImage:ImageView = itemView.findViewById(R.id.news_image)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
}