package com.teresaferme.todos.main

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import com.teresaferme.todos.base.BaseViewModel
import com.teresaferme.todos.model.TODOModel

class MainViewModel : BaseViewModel() {
    private var todoList = arrayListOf(
                TODOModel(
                    "name1", "name2", Color.Blue
                ), TODOModel(
                    "name1", "name2", Color.Red
                ), TODOModel(
                    "name1", "name2", Color.Green
                ), TODOModel(
                    "name1", "name2", Color.Blue
                )
            )

    val mustUpdateTODOList: MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }
    val isCalendarViewSelected: MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }
    val addingTODO: MutableLiveData<Boolean> by lazy {
        MutableLiveData(false)
    }

    fun startAddTODOProcess() {
        this.addingTODO.value = true
    }

    fun endAddTODOProcess() {
        this.addingTODO.value = false
    }

    fun getTODOsList(): List<TODOModel> {
        this.mustUpdateTODOList.value = false
        return todoList
    }

    fun addTODO(todoModel: TODOModel) {
        val list = ArrayList<TODOModel>()
        this.todoList.forEach {
            list.add(it)
        }
        list.add(todoModel)
        this.todoList = list
        this.mustUpdateTODOList.value = true
    }

    fun updateSelectedView() {
        this.isCalendarViewSelected.value = !(isCalendarViewSelected.value ?: true)
    }
}