package com.kryptkode.recomponents

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors


@SuppressLint("VisibleForTests")
abstract class ListComponentAdapter<D : ComparableById>(config: AsyncDifferConfig<D> =
                                                                AsyncDifferConfig.Builder(DiffUtilCallback<D>())
                                                                        .setBackgroundThreadExecutor(backgroundThreadExecutor)
                                                                        .build()) : ListAdapter<D, UIComponentForList<D>>(config) {
    abstract fun getComponentForList(i: Int): UIComponentForList<D>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UIComponentForList<D> {
        return getComponentForList(viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return (getItem(position) as ComparableById).type
    }

    override fun onBindViewHolder(holder: UIComponentForList<D>, position: Int) {
        holder.newState(getItem(position))
    }

    companion object {
        private val backgroundThreadExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    }
}