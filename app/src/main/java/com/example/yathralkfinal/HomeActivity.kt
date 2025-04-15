package com.example.yathralkfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.yathralkfinal.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var bottomNav: BottomNavigationView
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupWindowInsets()
        setupBottomNavigation()

        // Load default fragment if no saved state
        if (savedInstanceState == null) {
            loadFragment(HomeFragment(), addToBackStack = false)
        }
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupBottomNavigation() {
        bottomNav = binding.bottomNavigationView
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (currentFragment !is HomeFragment) {
                        loadFragment(HomeFragment())
                    }
                    true
                }
                R.id.navigation_explore -> {
                    if (currentFragment !is ExploreFragment) {
                        loadFragment(ExploreFragment())
                    }
                    true
                }
                R.id.navigation_profile -> {
                    if (currentFragment !is ProfileFragment) {
                        loadFragment(ProfileFragment())
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        currentFragment = fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}