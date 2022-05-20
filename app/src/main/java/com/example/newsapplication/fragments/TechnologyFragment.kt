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
import com.example.newsapplication.databinding.FragmentTechnologyBinding

class TechnologyFragment : Fragment() {
    private  lateinit var binding:FragmentTechnologyBinding

    private lateinit var technologyTitle:Array<String>
    private lateinit var technologyImage:Array<Int>
    private lateinit var technologyLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTechnologyBinding.inflate(layoutInflater)

        //Data source
        technologyLinks = arrayOf(
            "https://edition.cnn.com/specials/tech/innovate",
            "https://us.cnn.com/specials/tech/gadget",
            "https://us.cnn.com/specials/tech/foreseeable-future",
            "https://us.cnn.com/specials/tech/mission-ahead"
        )

        technologyTitle = arrayOf("Innovate",
            "Gadget",
            "Foreseeable Future",
            "Mission:Ahead"
        )
        technologyImage = arrayOf(R.drawable.innovate_tech, R.drawable.gadgets_tech, R.drawable.foreseen_tech,
            R.drawable.mission_tech
        )

        val gridView = binding.gridViewTechnology

        arrayList = arrayListOf()

        for (i in technologyTitle.indices){
            val rowItem = Data(technologyTitle[i], technologyImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", technologyLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}