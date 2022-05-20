package com.example.newsapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapplication.Data
import com.example.newsapplication.WebViewInflater
import com.example.newsapplication.R
import com.example.newsapplication.adapters.CustomAdapter
import com.example.newsapplication.databinding.FragmentSportsBinding

class SportsFragment : Fragment() {
    private  lateinit var binding: FragmentSportsBinding

    private lateinit var sportsTitle:Array<String>
    private lateinit var sportsImage:Array<Int>
    private lateinit var sportsLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportsBinding.inflate(layoutInflater)

        //Data source
        sportsLinks = arrayOf(
            "https://edition.cnn.com/sport/football",
            "https://edition.cnn.com/sport/tennis",
            "https://edition.cnn.com/sport/golf",
            "https://edition.cnn.com/sport/motorsport"
        )

        sportsTitle = arrayOf("Football",
            "Tennis",
            "Golf",
            "Motorsports"
        )
        sportsImage = arrayOf(R.drawable.football_sports, R.drawable.tennis_sports, R.drawable.golf_sports,
            R.drawable.motor_sports
        )

        val gridView = binding.gridViewSports

        arrayList = arrayListOf()

        for (i in sportsTitle.indices){
            val rowItem = Data(sportsTitle[i], sportsImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", sportsLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}