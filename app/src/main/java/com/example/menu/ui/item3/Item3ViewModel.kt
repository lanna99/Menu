package com.example.menu.ui.item3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Item3ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is item3 Fragment"
    }
    val text: LiveData<String> = _text
}