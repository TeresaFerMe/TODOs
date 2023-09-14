package com.teresaferme.todos.model

import androidx.compose.ui.graphics.Color

data class TODOModel(
    val name: String, val dueDate: String, val categoryColor: Color, var isCompleted: Boolean
)
