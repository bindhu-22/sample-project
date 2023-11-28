package com.example.databidingapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databidingapplication.databinding.ActivityNextBinding

class DisplayActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNextBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_next
        )

        val profile = intent.getSerializableExtra("profile") as Profile
        binding.profile = profile
        binding.setLifecycleOwner(this)
    }
}