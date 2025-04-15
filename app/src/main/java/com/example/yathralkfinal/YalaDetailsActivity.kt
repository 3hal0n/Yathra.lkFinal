package com.example.yathralkfinal

import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class YalaDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yala_details)

        // Set up back button click listener
        findViewById<View>(R.id.backButton).setOnClickListener {
            finish()  // Close this activity and return to previous
        }

        // You can add more click listeners here as needed
        // For example, for the book now button:
        findViewById<View>(R.id.bookNowButton)?.setOnClickListener {
            // Handle book now button click
            // You could start a new booking activity here
        }
    }
}