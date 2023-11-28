package com.example.databidingapplication

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import android.database.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.adapters.ListenerUtil
import com.example.databidingapplication.databinding.ActivityMainBinding
import java.io.Serializable

class Profile: Serializable, BaseObservable() {

    var isValidProfile = ObservableBoolean(false)
        get() = field
        set(value) {
            field = value
        }

    @get:Bindable
    var fullName = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.fullName)
        }

    @get:Bindable
    var emailId = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.emailId)
        }

    @get:Bindable
    var contactNumber = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.contactNumber)
        }

    @get:Bindable
    var age = ""
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}