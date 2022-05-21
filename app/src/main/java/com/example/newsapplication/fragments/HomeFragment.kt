package com.example.newsapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.Data
import com.example.newsapplication.R
import com.example.newsapplication.WebViewInflater
import com.example.newsapplication.adapters.NewsCustomAdapter
import com.example.newsapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private  lateinit var binding:FragmentHomeBinding

    private lateinit var arrayList:ArrayList<Data>
    lateinit var titles:Array<String>
    lateinit var images:Array<Int>
    lateinit var urls:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //Generating A data source
        urls = arrayOf("https://us.cnn.com/specials/us/crime-and-justice",
            "https://us.cnn.com/specials/us/energy-and-environment",
            "https://us.cnn.com/weather",
            "https://us.cnn.com/specials/space-science"
        )
        titles = arrayOf("Crime + Justice",
            "Energy + Environment",
            "Extreme Weather",
            "Space + Science"
        )

        images = arrayOf(
            R.drawable.crime_justice, R.drawable.energy_environment, R.drawable.weather,
            R.drawable.space_science
        )

        val recyclerView = binding.listViewHome
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        arrayList = arrayListOf()

        for (i in titles.indices){
            val row = Data(titles[i], images[i])
            arrayList.add(row)
        }

        val adapter = NewsCustomAdapter(arrayList)
        recyclerView.adapter = adapter

        adapter.setItemClickListener(object: NewsCustomAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, WebViewInflater::class.java)
                intent.putExtra("urls", urls[position])
                startActivity(intent)
            }
        })


        return binding.root


    }
}