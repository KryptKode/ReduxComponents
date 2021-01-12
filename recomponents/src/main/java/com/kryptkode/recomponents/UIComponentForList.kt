package com.kryptkode.recomponents

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class UIComponentForList<T>(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
    var cache: T? = null

    protected abstract fun render(t: T)

    protected open fun renderSubComponents(state: T) {

    }

    fun newState(state: T) {
        cache = state
        render(state)
        renderSubComponents(state)
    }

}