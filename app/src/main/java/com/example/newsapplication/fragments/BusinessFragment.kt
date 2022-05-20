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
import com.example.newsapplication.databinding.FragmentBusinessBinding

class BusinessFragment : Fragment() {
    private  lateinit var binding:FragmentBusinessBinding

    private lateinit var businessTitle:Array<String>
    private lateinit var businessImage:Array<Int>
    private lateinit var businessLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusinessBinding.inflate(layoutInflater)

        //Data source
        businessLinks = arrayOf(
            "https://money.cnn.com/data/markets/",
            "https://edition.cnn.com/business/tech",
            "https://edition.cnn.com/business/media",
            "https://edition.cnn.com/business/perspectives"
        )

       businessTitle = arrayOf("Markets",
            "Technology",
            "Media",
            "Perspective"
        )
        businessImage = arrayOf(R.drawable.market_business, R.drawable.tech_market, R.drawable.media_business,
            R.drawable.perpective_business
        )

        val gridView = binding.gridViewBusiness

        arrayList = arrayListOf()

        for (i in businessTitle.indices){
            val rowItem = Data(businessTitle[i], businessImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", businessLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}