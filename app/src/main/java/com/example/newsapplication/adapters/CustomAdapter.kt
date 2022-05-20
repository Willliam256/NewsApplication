package com.example.newsapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapplication.Data
import com.example.newsapplication.R

class CustomAdapter(private val context: Context, private val arrayList:ArrayList<Data>):BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position.toLong()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val layoutView = inflater.inflate(R.layout.item_layout_gridview, viewGroup, false)
        layoutView.findViewById<TextView>(R.id.title_news).text = arrayList[position].titleNews
        layoutView.findViewById<ImageView>(R.id.news_image).setImageResource(arrayList[position].imageNews)

        return layoutView
    }

}