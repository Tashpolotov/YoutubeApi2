package com.example.youtubeapi.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel :ViewModel(){

    val loading = MutableLiveData<Boolean>()
}