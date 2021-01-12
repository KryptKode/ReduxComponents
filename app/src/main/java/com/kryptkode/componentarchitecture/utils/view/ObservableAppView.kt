package com.kryptkode.componentarchitecture.utils.view

interface ObservableAppView<ListenerType> : AppView {
    fun registerListener(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}