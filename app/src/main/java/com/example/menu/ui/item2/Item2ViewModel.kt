package com.example.menu.ui.item2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Item2ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is item2 Fragment"
    }
    val text: LiveData<String> = _text
}