package com.kryptkode.componentarchitecture.utils.view

import android.content.Context
import android.view.View
import androidx.annotation.StringRes

abstract class BaseAppView : AppView {

    protected fun <T : View> findViewById(id: Int): T {
        return rootView.findViewById(id)
    }

    protected val context: Context
        get() = rootView.context

    protected fun getString(@StringRes id: Int, vararg any: Any): String {
        return context.getString(id, *any)
    }
}