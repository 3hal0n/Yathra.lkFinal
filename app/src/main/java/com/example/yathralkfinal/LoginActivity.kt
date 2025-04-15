package com.example.yathralkfinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_login)

            val loginButton = findViewById<Button>(R.id.loginButton)
            loginButton.setOnClickListener {
                val username = findViewById<EditText>(R.id.username).text.toString()
                val password = findViewById<EditText>(R.id.password).text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(this, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("LoginActivity", "Initialization error", e)
            Toast.makeText(this, "App initialization failed", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}