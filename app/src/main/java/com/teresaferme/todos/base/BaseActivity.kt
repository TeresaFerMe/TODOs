package com.teresaferme.todos.base

import androidx.activity.ComponentActivity

abstract class BaseActivity: ComponentActivity() {

    override fun onResume() {
        super.onResume()
        this.setUpObservables()
    }

    abstract fun setUpObservables()
}