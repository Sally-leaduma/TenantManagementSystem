package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

// This defines the Tenant structure directly since you don't have a separate Tenant.kt file
data class Tenant(val name: String, val phone: String, val rent: String)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. SAVE BUTTON LOGIC
        binding.saveButton.setOnClickListener {
            // FIXED LINES: These now match the official IDs from your lab layout manual
            val name = binding.tenantNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()

            val tenant = Tenant(name, phone, rent)
            lastTenant = tenant

            Toast.makeText(this, "Tenant Saved Successfully!", Toast.LENGTH_SHORT).show()
        }

        // 2. CALL BUTTON LOGIC (Step 12)
        binding.callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Implicit Intent: Launches phone dialer application
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }
    }
}