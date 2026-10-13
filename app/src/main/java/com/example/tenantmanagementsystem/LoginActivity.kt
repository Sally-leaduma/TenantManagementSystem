package com.example.tenantmanagementsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityLoginBinding
import android.net.Uri

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val registeredEmail = intent.getStringExtra("EMAIL")
        if (registeredEmail != null) {
            binding.emailEditText.setText(registeredEmail)
            binding.helpTextView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.strathmore.edu"))
                startActivity(intent)
            }
        }

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()
            binding.registerTextView.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Explicit Intent: Open MainActivity (the Add Tenant screen) directly
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Closes LoginActivity so clicking Back doesn't trap users here
        }
    }
}

