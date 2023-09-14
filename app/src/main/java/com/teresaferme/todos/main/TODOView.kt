package com.teresaferme.todos.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.teresaferme.todos.R
import com.teresaferme.todos.model.TODOModel
import com.teresaferme.todos.ui.theme.categoryLineSize
import com.teresaferme.todos.ui.theme.commonPadding
import com.teresaferme.todos.ui.theme.iconSize
import com.teresaferme.todos.ui.theme.todoCalendarCardHeight

@Composable
fun TODOListItem(
    todoModel: TODOModel, onCheckedChange: (Boolean) -> Unit
) {
    Card(modifier = Modifier.wrapContentHeight()) {
        Divider(
            modifier = Modifier.height(categoryLineSize), color = todoModel.categoryColor
        )
        Row(Modifier.padding(commonPadding)) {
            Checkbox(checked = todoModel.isCompleted, onCheckedChange = {
                onCheckedChange.invoke(it)
            })
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
            ) {
                Text(text = todoModel.name)
                Text(text = todoModel.dueDate)
            }
            Icon(
                modifier = Modifier
                    .size(iconSize)
                    .weight(0.25f),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "TODO Icon"
            )
        }
    }

}

@Composable
fun TODOCalendarItem(
    todoModel: TODOModel, onCheckedChange: (Boolean) -> Unit
) {
    Card {
        Row(modifier = Modifier.heightIn(max = todoCalendarCardHeight)) {
            Spacer(
                modifier = Modifier
                    .width(categoryLineSize)
                    .background(todoModel.categoryColor)
                    .fillMaxHeight()
            )
            Checkbox(checked = todoModel.isCompleted, onCheckedChange = {
                onCheckedChange.invoke(it)
            })
            Column(
                modifier = Modifier.wrapContentSize()
            ) {
                Text(text = todoModel.name, modifier = Modifier.wrapContentSize())
                Text(text = todoModel.dueDate, modifier = Modifier.wrapContentSize())
            }
            Icon(
                modifier = Modifier.size(iconSize),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "TODO Icon"
            )
        }
    }
}

@Preview
@Composable
fun TODOListPreview() {
    Surface(modifier = Modifier.wrapContentSize()) {
        TODOListItem(
            TODOModel(name = "name", dueDate = "Due date", categoryColor = Color.Blue, false)
        ) {}
    }
}

@Preview
@Composable
fun TODOCalendarPreview() {
    TODOCalendarItem(
        TODOModel(name = "name", dueDate = "Due date", categoryColor = Color.Blue, false)
    ) {}
}