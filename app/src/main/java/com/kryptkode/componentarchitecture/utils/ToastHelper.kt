package com.kryptkode.componentarchitecture.utils

import android.content.Context
import android.widget.Toast

class ToastHelper constructor(private val context: Context) {
    fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}