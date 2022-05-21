package com.example.newsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.newsapplication.databinding.ActivityLogoutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.system.exitProcess

class LogoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogoutBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        auth = Firebase.auth

        binding.logout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LandingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        binding.cancel.setOnClickListener {
            finish()
        }
    }
}