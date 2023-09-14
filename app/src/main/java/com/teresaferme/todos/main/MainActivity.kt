package com.teresaferme.todos.main

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.teresaferme.todos.base.BaseActivity
import com.teresaferme.todos.model.TODOModel

class MainActivity : BaseActivity() {
    private val viewModel : MainViewModel by viewModels()
    private val isCalendarViewSelected by lazy {
        mutableStateOf(viewModel.isCalendarViewSelected.value ?: false)
    }

    override fun setUpObservables() {
        viewModel.isCalendarViewSelected.observe(this) {
            isCalendarViewSelected.value = it
        }
    }

    @Composable
    override fun MainContent() {
        val list = listOf(
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
        Column {
            if (!isCalendarViewSelected.value) ListView(todoList = list)
            else CalendarView(todoList = list)
            Text(text = "change view", modifier = Modifier.clickable {
                Log.d(this@MainActivity.javaClass.name, "press click")
                viewModel.isCalendarViewSelected.value = !isCalendarViewSelected.value
            })
        }
    }
}