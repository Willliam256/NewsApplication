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
import com.example.newsapplication.databinding.FragmentStyleBinding

class StyleFragment : Fragment() {
    private  lateinit var binding: FragmentStyleBinding

    private lateinit var styleTitle:Array<String>
    private lateinit var styleImage:Array<Int>
    private lateinit var styleLinks:Array<String>
    private lateinit var arrayList:ArrayList<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStyleBinding.inflate(layoutInflater)

        //Data source
        styleLinks = arrayOf(
            "https://edition.cnn.com/style/design",
            "https://edition.cnn.com/style/fashion",
            "https://edition.cnn.com/style/luxury",
            "https://edition.cnn.com/style/beauty"
        )

        styleTitle = arrayOf("Design",
            "Fashion",
            "Luxury",
            "Beauty"
        )
        styleImage = arrayOf(R.drawable.design_style, R.drawable.fashion_style, R.drawable.luxury_style,
            R.drawable.beauty_style
        )

        val gridView = binding.gridViewStyle

        arrayList = arrayListOf()

        for (i in styleTitle.indices){
            val rowItem = Data(styleTitle[i], styleImage[i])
            arrayList.add(rowItem)
        }

        gridView.adapter = activity?.let { CustomAdapter(it, arrayList) }
        gridView.isClickable = true

        gridView.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(activity, WebViewInflater::class.java)

            intent.putExtra("urls", styleLinks[position])

            startActivity(intent)
        }
        return (binding.root)
    }
}