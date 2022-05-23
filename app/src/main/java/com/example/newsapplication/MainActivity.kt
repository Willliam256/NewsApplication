package com.example.newsapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.newsapplication.databinding.ActivityMainBinding
import com.example.newsapplication.fragments.TravelFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //invoking the nav function
        //navProfile()

        //setting up the firebase
        auth = FirebaseAuth.getInstance()


        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //setting up the navigation drawer
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navigationViewView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val headerView = navigationViewView.getHeaderView(0)
        val emailNav = headerView.findViewById<TextView>(R.id.navEmail)

        //displaying current user email on drawer
        if (auth.currentUser != null){
            val email = auth.currentUser!!.email
            emailNav.text = email

        }


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.travelFragment, R.id.technologyFragment, R.id.businessFragment, R.id.healthFragment,
                R.id.entertainmentFragment, R.id.styleFragment, R.id.sportsFragment
            ), drawerLayout
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationViewView.setupWithNavController(navController)

        //customize the navigation drawer icon #All that is required
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         //Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}