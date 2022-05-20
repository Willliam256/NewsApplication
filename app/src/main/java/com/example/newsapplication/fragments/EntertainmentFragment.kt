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
import com.example.newsapplication.databinding.FragmentEntertainmentBinding

class EntertainmentFragment : Fragment() {
    private  lateinit var binding: FragmentEntertainmentBinding

    private lateinit var entertainmentTitle:Array<String>
    private lateinit var entertainmentImage:Array<Int>
    private lateinit var entertainmentLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEntertainmentBinding.inflate(layoutInflater)

        //Data source
        entertainmentLinks = arrayOf(
            "https://edition.cnn.com/entertainment/celebrities",
            "https://edition.cnn.com/entertainment/movies",
            "https://edition.cnn.com/entertainment/tv-shows",
            "https://edition.cnn.com/entertainment/culture"
        )

        entertainmentTitle = arrayOf("Stars",
            "Screen",
            "Binge",
            "Culture"
        )
        entertainmentImage = arrayOf(R.drawable.stars_ent, R.drawable.screen_ent, R.drawable.binge_ent,
            R.drawable.culture_ent
        )

        val gridView = binding.gridViewEntertainment

        arrayList = arrayListOf()

        for (i in entertainmentTitle.indices){
            val rowItem = Data(entertainmentTitle[i], entertainmentImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", entertainmentLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}