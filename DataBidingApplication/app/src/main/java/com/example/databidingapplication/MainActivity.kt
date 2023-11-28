package com.example.databidingapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.databidingapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val profile = Profile()

        binding.submitButton.setOnClickListener {
            if (isValidForm(binding)) {
                val intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("profile", profile)
                startActivity(intent)
            }
        }
        binding.profile = profile
        binding.setLifecycleOwner(this)
        Log.d("name", profile.fullName)
    }

    fun isValidForm(binding: ActivityMainBinding): Boolean {
        var isValid = true
        if (binding.fullName.text.toString().length < 4) {
            binding.fullName.setError("Full name must be more than 4 characters")
            isValid = false
        }
        if (binding.emailId.text.toString().length < 5 || !binding.emailId.text.toString().contains('@')) {
            binding.emailId.setError("Email Id must be more than 5 characters")
            isValid = false
        }
        if (binding.password.text.toString().length < 8) {
            binding.password.setError("Password must be atleast 8 characters")
            isValid = false
        }
        if (!binding.confirmPassword.text.toString().equals(binding.password.text.toString())) {
            binding.confirmPassword.setError("Password didn't match")
            isValid = false
        }
        if (binding.contactNumber.text.toString().length != 10) {
            binding.contactNumber.setError("Contact must be a number of 10 digits")
            isValid = false
        }
        if (binding.age.text.toString().toInt() < 8 || binding.age.text.toString().toInt() > 99) {
            binding.age.setError("age must be in range 8 to 99")
            isValid = false
        }
        return isValid
    }
}