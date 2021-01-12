package com.kryptkode.recomponents

import androidx.annotation.UiThread

abstract class UIComponent<T> : Subscriber<T> {
    var cache: T? = null
    protected lateinit var dispatch: DispatchFunction
    var renderCounter = 0

    @UiThread
    protected abstract fun render(state: T)

    override fun newState(selectedState: T, dispatch: DispatchFunction) {
        this.dispatch = dispatch
        renderOnUIThread(selectedState)
    }


    private fun renderOnUIThread(state: T) {
        mainThreadHandler.post{
            cache = state
            render(state)
            renderCounter++
            if(renderCounter == Int.MAX_VALUE){
                renderCounter = 0
            }
        }
    }

    @UiThread
    fun hideComponent() {
    }

    override fun onUnsubscribed(dispatch: (Action) -> Unit) {
        mainThreadHandler.post{
            hideComponent()
        }
    }

}