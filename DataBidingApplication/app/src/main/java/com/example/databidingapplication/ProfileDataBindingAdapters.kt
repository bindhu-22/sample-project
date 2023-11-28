package com.example.databidingapplication

import android.graphics.Color
import android.graphics.Typeface
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

object ProfileDataBindingAdapters {
    @InverseBindingAdapter(attribute = "android:text")
    @JvmStatic fun getEditText(view: EditText): String {
        val editText = view.text.toString()
        return editText
    }

    @BindingAdapter("android:email")
    @JvmStatic fun setEmail(view: TextView, text: String) {
        view.text = text
        view.setTypeface(null, Typeface.BOLD)
        view.setTextColor(Color.GREEN)
    }
}