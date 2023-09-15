package com.teresaferme.todos.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.teresaferme.todos.ui.theme.TODOsTheme
import com.teresaferme.todos.ui.theme.commonPadding

abstract class BaseActivity: ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOsTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CenterAlignedTopAppBar(title = { Text(text = "TODOs")})
                    MainContent(modifier = Modifier.padding(commonPadding))
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
    abstract fun MainContent(modifier: Modifier)
}