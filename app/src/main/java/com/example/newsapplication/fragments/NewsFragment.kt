package com.example.newsapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapplication.NewsData
import com.example.newsapplication.NewsWebView
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsCustomAdapter
import com.example.newsapplication.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private  lateinit var binding:FragmentNewsBinding

    private lateinit var newsTitle:Array<String>
    private lateinit var newsImage:Array<Int>
    private lateinit var newsLinks:Array<String>
    private lateinit var arrayList:ArrayList<NewsData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)

        //Data source
        newsLinks = arrayOf(
            "https://us.cnn.com/specials/us/crime-and-justice",
            "https://us.cnn.com/specials/us/energy-and-environment",
            "https://us.cnn.com/weather",
            "https://us.cnn.com/specials/space-science"
        )

        newsTitle = arrayOf("Crime + Justice",
            "Energy + Environment",
            "Extreme Weather",
            "Space + Science"
        )
        newsImage = arrayOf(R.drawable.crime_justice, R.drawable.energy_environment, R.drawable.weather,
            R.drawable.space_science
        )

        val gridView = binding.gridViewNews

        arrayList = arrayListOf()

        for (i in newsTitle.indices){
            val rowItem = NewsData(newsTitle[i], newsImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { NewsCustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, NewsWebView::class.java)

            intent.putExtra("urls", newsLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}