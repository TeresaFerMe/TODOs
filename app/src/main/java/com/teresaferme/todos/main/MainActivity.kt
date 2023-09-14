package com.teresaferme.todos.main

import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.teresaferme.todos.add.AddTODO
import com.teresaferme.todos.base.BaseActivity
import com.teresaferme.todos.model.TODOModel

class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val isCalendarViewSelected by lazy {
        mutableStateOf(viewModel.isCalendarViewSelected.value ?: false)
    }
    private val isAddModalShown by lazy {
        mutableStateOf(viewModel.addingTODO.value ?: false)
    }
    private val todoList = mutableStateOf(listOf<TODOModel>())

    override fun setUpObservables() {
        todoList.value = viewModel.getTODOsList()
        viewModel.isCalendarViewSelected.observe(this) {
            isCalendarViewSelected.value = it
        }
        viewModel.mustUpdateTODOList.observe(this) {
            if (it) todoList.value = viewModel.getTODOsList()
        }
        viewModel.addingTODO.observe(this) {
            this.isAddModalShown.value = it
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun MainContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopCenter)
            ) {
                if (!isCalendarViewSelected.value) ListView(todoList = todoList.value)
                else CalendarView(todoList = todoList.value)
            }
            Row(Modifier.align(Alignment.BottomEnd)) {
                Text(text = "Change view", modifier = Modifier.clickable {
                        viewModel.updateSelectedView()
                    })
                Text(text = "Add TODO", modifier = Modifier.clickable {
                        viewModel.startAddTODOProcess()
                    })
            }
            if (isAddModalShown.value) {
                ModalDrawerSheet(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    AddTODO()
                    /*viewModel.addTODO(
                        TODOModel(
                            name = "nuevo ${viewModel.getTODOsList().count()}",
                            dueDate = "due",
                            categoryColor = Color.Cyan
                        )
                    )*/
                    //viewModel.endAddTODOProcess()
                }
            }
        }
    }
}