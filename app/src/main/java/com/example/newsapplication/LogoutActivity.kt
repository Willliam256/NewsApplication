package com.example.newsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newsapplication.databinding.ActivityLogoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogoutBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.logout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, LandingActivity::class.java))
            finish()
        }
    }
}