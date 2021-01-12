package com.kryptkode.recomponents

import androidx.lifecycle.ViewModel

class UIComponentManager<AppState : StateType>(private val store: Store<AppState>) : ViewModel() {
    private val componentUnsubscribeHooks= mutableListOf<()->Unit>()

    public override fun onCleared() {
        super.onCleared()
        componentUnsubscribeHooks.forEach { func->
            func()
        }
    }

    fun <ComponentState> subscribe(uiComponent: UIComponent<ComponentState>, stateTransform: (AppState)-> ComponentState) {
        componentUnsubscribeHooks.add(store.subscribe(uiComponent, stateTransform))
    }
}