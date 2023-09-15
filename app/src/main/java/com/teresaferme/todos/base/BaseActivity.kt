package com.teresaferme.todos.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.teresaferme.todos.ui.theme.TODOsTheme
import com.teresaferme.todos.ui.theme.commonPadding

abstract class BaseActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOsTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(commonPadding), color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        this.setUpObservables()
    }

    abstract fun setUpObservables()

    @Composable
    abstract fun MainContent()
}