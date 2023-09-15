package com.teresaferme.todos.add

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.teresaferme.todos.R
import com.teresaferme.todos.ui.theme.TODOsTheme
import com.teresaferme.todos.ui.theme.commonPadding
import com.teresaferme.todos.ui.theme.iconSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTODO(
    onAddClicked: (name: String, due: String) -> Unit = { _, _ -> }, onCloseClicked: () -> Unit = {}
) {
    TODOsTheme {
        Column(
            modifier = Modifier
                .padding(commonPadding)
                .wrapContentHeight()
        ) {
            var name by remember { mutableStateOf("") }
            var due by remember { mutableStateOf("") }
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Close modal",
                modifier = Modifier
                    .align(Alignment.End)
                    .size(iconSize)
                    .clickable {
                        onCloseClicked.invoke()
                    })
            Text(text = "Add TODO")
            OutlinedTextField(placeholder = { Text(text = "TODO name") },
                label = { Text(text = "TODO name") },
                value = name,
                onValueChange = {
                    name = it
                })
            OutlinedTextField(placeholder = { Text(text = "TODO due") },
                label = { Text(text = "TODO due") },
                value = due,
                onValueChange = {
                    due = it
                })
            TextButton(modifier = Modifier.align(Alignment.End), onClick = {
                onAddClicked.invoke(
                    name, due
                )
            }) {
                Text("Add")
            }
        }
    }
}

@Preview
@Composable
fun AddTODOPreview() {
    AddTODO()
}