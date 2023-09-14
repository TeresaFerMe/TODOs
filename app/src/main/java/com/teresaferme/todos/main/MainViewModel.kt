package com.teresaferme.todos.main

import androidx.lifecycle.MutableLiveData
import com.teresaferme.todos.base.BaseViewModel

class MainViewModel: BaseViewModel() {
    val isCalendarViewSelected: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }
}