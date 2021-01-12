package com.kryptkode.recomponents

import java.util.concurrent.CopyOnWriteArrayList


class StoreImpl<State : StateType>(
        initialState: State,
        private val rootReducer: Reducer<State>,
        private val middleWares: List<Middleware<State>>) : Store<State> {

    private lateinit var newState: State
    private var currentState = initialState

    override val state: State
        get() = currentState


    private val subscriptions: MutableList<Subscription<State, StateType>> = CopyOnWriteArrayList()

    override fun dispatchFunction(): DispatchFunction {
        return {
            dispatch(it)
        }
    }

    override fun dispatch(action: Action) {
        nextMiddleware(0)(currentState, action) {
            dispatch(it)
        }
        if (newState != this.currentState) {
            currentState = newState
            subscriptions.forEach {
                it.stateUpdated(currentState)
            }
        }
    }

    private fun nextMiddleware(index: Int): Next<State> {
        return if (index == middleWares.size) {
            { _, action, _ ->
                newState = rootReducer(action, currentState)
                action
            }

        } else {
            { state, action, dispatchFunction ->
                middleWares[index](dispatchFunction, state, action, nextMiddleware(index + 1))
            }
        }
    }

    override fun <SelectedState, AppState> subscribe(subscriber: Subscriber<SelectedState>, changeFunc: (AppState) -> SelectedState): () -> Unit {
        subscriptions.forEachIndexed { index, subscription ->
            if (subscription.subscriber === subscriber) {
                subscriptions.removeAt(index)
            }
        }

        val subscription = Subscription(subscriber, changeFunc, dispatchFunction())
        subscriptions.add(subscription as Subscription<State, StateType>)
        subscription.stateUpdated(currentState)
        return { unsubscribe(subscription) }
    }


    fun unsubscribe(subscription: Subscription<State, StateType>) {
        subscriptions.remove(subscription)
        subscription.subscriber.onUnsubscribed(dispatchFunction())
    }

    override fun unsubscribeAll() {
        for (it in subscriptions) {
            it.subscriber.onUnsubscribed(dispatchFunction())
        }
        subscriptions.clear()
    }


    class Subscription<State, SelectedState>(
            val subscriber: Subscriber<SelectedState>,
            private val transform: (State) -> SelectedState?,
            private val dispatchFunction: DispatchFunction) {

        private var oldSelectedState: SelectedState? = null

        fun stateUpdated(newState: State) {
            val selectedState: SelectedState = transform.invoke(newState) ?: return
            if (oldSelectedState == null || oldSelectedState != selectedState) {
                subscriber.newState(selectedState, dispatchFunction)
                oldSelectedState = selectedState
            }
        }
    }
}