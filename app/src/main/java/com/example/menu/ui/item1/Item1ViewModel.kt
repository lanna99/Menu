package com.example.menu.ui.item1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Item1ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is item1 Fragment"
    }
    val text: LiveData<String> = _text
}