package com.teresaferme.todos.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.teresaferme.todos.model.TODOModel
import com.teresaferme.todos.ui.theme.commonPadding
import com.teresaferme.todos.ui.theme.todoCalendarCardSpacing

@Composable
fun ListView(
    todoList: List<TODOModel>
) {
    LazyColumn(content = {
        todoList.forEach {
            item {
                TODOListItem(it)
            }
        }
    }, verticalArrangement = Arrangement.spacedBy(todoCalendarCardSpacing))
}

@Composable
fun CalendarView(
    todoList: List<TODOModel>
) {
    val categoriesList = mutableSetOf<Color>()
    todoList.forEach {
        categoriesList.add(it.categoryColor)
    }
    Column {
        categoriesList.forEach {
            LazyRow(modifier = Modifier.wrapContentSize(), content = {
                todoList.forEach { model ->
                    if (model.categoryColor == it) {
                        item {
                            TODOCalendarItem(model)
                        }
                    }
                }
            }, horizontalArrangement = Arrangement.spacedBy(todoCalendarCardSpacing))
            Spacer(modifier = Modifier.size(commonPadding))
        }
    }
}

@Preview
@Composable
fun ListViewPreview() {
    ListView(
        listOf(
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
    )
}

@Preview
@Composable
fun CalendarViewPreview() {
    CalendarView(todoList = listOf(
        TODOModel(
            "name1", "name2", Color.Blue
        ), TODOModel(
            "name1", "name2", Color.Red
        ), TODOModel(
            "name1", "name2", Color.Green
        ), TODOModel(
            "name1", "name2", Color.Blue
        )
    ))
}