package com.example.newsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newsapplication.databinding.ActivityExitBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.system.exitProcess

class ExitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExitBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.exit.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "Exit Successful", Toast.LENGTH_LONG).show()
            finishAffinity()
        }
    }
}