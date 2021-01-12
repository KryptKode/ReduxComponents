package com.kryptkode.recomponents

interface Store<State : StateType?> {
    fun dispatch(action: Action)
    fun dispatchFunction(): DispatchFunction
    val state: State
    fun <SelectedState, AppState> subscribe(subscriber: Subscriber<SelectedState>, changeFunc: (AppState)->SelectedState): ()->Unit
    fun unsubscribeAll()
}