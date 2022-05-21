package com.example.newsapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.newsapplication.databinding.ActivityExitBinding

class ExitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding.exit.setOnClickListener {
            Toast.makeText(this, "Exit Successful", Toast.LENGTH_LONG).show()
            finishAffinity()
        }

        binding.cancel.setOnClickListener {
            finish()
        }
    }
}