package com.example.newsapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newsapplication.databinding.ActivityExitBinding
import kotlin.system.exitProcess

class ExitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener {
            Toast.makeText(this, "Exit Successful", Toast.LENGTH_LONG).show()
            finishAffinity()
        }

        binding.cancel.setOnClickListener {
            finish()
        }
    }
}