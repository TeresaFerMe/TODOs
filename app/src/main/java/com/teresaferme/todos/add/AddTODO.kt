package com.teresaferme.todos.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.teresaferme.todos.R
import com.teresaferme.todos.ui.theme.commonPadding
import com.teresaferme.todos.ui.theme.iconSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTODO() {
    Column(modifier = Modifier.padding(commonPadding).wrapContentHeight()) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Close modal",
            modifier = Modifier
                .align(Alignment.End)
                .size(iconSize)
        )
        Text(text = "Add TODO")
        OutlinedTextField(placeholder = { Text(text = "TODO name") },
            label = { Text(text = "TODO name") },
            value = "",
            onValueChange = {})
        OutlinedTextField(placeholder = { Text(text = "TODO due") },
            label = { Text(text = "TODO due") },
            value = "",
            onValueChange = {})
        TextButton(modifier = Modifier.align(Alignment.End), onClick = { /*TODO*/ }) {
            Text("Add")
        }
    }
}

@Preview
@Composable
fun AddTODOPreview() {
    AddTODO()
}