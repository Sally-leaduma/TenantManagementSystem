package com.example.tenantmanagementsystem



import java.io.Serializable


data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {

    // This formats how the tenant information will appear on the View Tenants screen
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}
