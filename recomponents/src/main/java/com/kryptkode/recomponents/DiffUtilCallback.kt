package com.kryptkode.recomponents

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.DiffUtil

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
class DiffUtilCallback<D : ComparableById> : DiffUtil.ItemCallback<D>() {
    override fun areItemsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem.idForComparison ==  newItem.idForComparison
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: D, newItem: D): Boolean {
        return oldItem ==  newItem
    }
}