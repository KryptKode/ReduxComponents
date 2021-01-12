package com.kryptkode.componentarchitecture.components

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kryptkode.componentarchitecture.CounterAction
import com.kryptkode.componentarchitecture.databinding.LayoutCounterBinding
import com.kryptkode.recomponents.UIComponent

data class CounterState (val count:String)

class CounterComponent (parent:ViewGroup) : UIComponent<CounterState>() {

    private val binding = LayoutCounterBinding.inflate(LayoutInflater.from(parent.context), parent, true)

    init {
        binding.decrement.setOnClickListener {
            dispatch(CounterAction.Decrement)
        }

        binding.increment.setOnClickListener {
            dispatch(CounterAction.Increment)
        }

        binding.multiply.setOnClickListener {
            dispatch(CounterAction.Multiply(40))
        }
    }

    override fun render(state: CounterState) {
        binding.count.text = state.count
    }

}