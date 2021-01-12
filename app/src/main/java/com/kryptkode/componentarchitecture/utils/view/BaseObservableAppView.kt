package com.kryptkode.componentarchitecture.utils.view

import java.util.*

abstract class BaseObservableAppView<ListenerType> : BaseAppView(),
    ObservableAppView<ListenerType> {
    private val listenersSet: MutableSet<ListenerType> =
        HashSet()

    override fun registerListener(listener: ListenerType) {
        this.listenersSet.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        this.listenersSet.remove(listener)
    }

    protected fun onEachListener(func: (ListenerType) -> Unit) {
        listeners.forEach {
            func(it)
        }
    }

    protected val listeners: Set<ListenerType>
        get() = Collections.unmodifiableSet(this.listenersSet)
}