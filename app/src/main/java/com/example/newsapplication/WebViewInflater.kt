package com.example.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebViewClient
import com.example.newsapplication.databinding.ActivityNewsWebViewBinding

class WebViewInflater : AppCompatActivity() {
    private lateinit var binding:ActivityNewsWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting the system toolbar not disappear
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val url = intent.getStringExtra("urls").toString()

        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)
        binding.webView.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack() else super.onBackPressed()

    }
}