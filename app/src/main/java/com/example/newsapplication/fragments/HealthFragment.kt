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
import com.example.newsapplication.databinding.FragmentHealthBinding

class HealthFragment : Fragment() {
    private  lateinit var binding: FragmentHealthBinding

    private lateinit var healthTitle:Array<String>
    private lateinit var healthImage:Array<Int>
    private lateinit var healthLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHealthBinding.inflate(layoutInflater)

        //Data source
        healthLinks = arrayOf(
            "https://edition.cnn.com/specials/health/fitness-life-but-better",
            "https://edition.cnn.com/specials/health/food-life-but-better",
            "https://edition.cnn.com/specials/health/sleep-life-but-better",
            "https://edition.cnn.com/specials/health/relationships-life-but-better"
        )

        healthTitle = arrayOf("Fitness",
            "Food",
            "Sleep",
            "Relationships"
        )
        healthImage = arrayOf(R.drawable.fitness_health, R.drawable.food_health, R.drawable.sleep_health,
            R.drawable.relationships_health
        )

        val gridView = binding.gridViewHealth

        arrayList = arrayListOf()

        for (i in healthTitle.indices){
            val rowItem = Data(healthTitle[i], healthImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", healthLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}