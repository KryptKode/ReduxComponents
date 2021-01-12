package com.kryptkode.componentarchitecture.utils.extension

import android.text.InputFilter
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView

fun TextView.imeListener(listener: () -> Unit) {
    setOnEditorActionListener { _, actionId, event ->
        if (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER) {
            if (event.action == KeyEvent.ACTION_UP) {
                listener()
            }
        } else if (actionId == EditorInfo.IME_ACTION_DONE) {
            listener()
        }
        false
    }
}

fun EditText.setCapsInputFilter() {
    val existingFilters = filters
    val newFilters = existingFilters.copyOf(existingFilters.size + 1)
    newFilters[existingFilters.size] = InputFilter.AllCaps()
    filters = newFilters
}