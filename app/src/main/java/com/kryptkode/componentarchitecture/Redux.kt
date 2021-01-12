package com.kryptkode.componentarchitecture

import com.kryptkode.recomponents.Action
import com.kryptkode.recomponents.Middleware
import com.kryptkode.recomponents.Reducer
import com.kryptkode.recomponents.StateType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

data class AppState(
    val count: Int = 0
) : StateType

sealed class CounterAction: Action {
    object Decrement: CounterAction()
    object Increment: CounterAction()
    data class Multiply (val value:Int): CounterAction()
}

val appReducer : Reducer<AppState> =  {action, appState ->
    when(action){
        is CounterAction.Increment -> appState.copy(count = appState.count + 1)

        is CounterAction.Decrement -> appState.copy(count = appState.count - 1)

        is CounterAction.Multiply -> appState.copy(count = action.value)
        else -> appState
    }
}

val multiplierMiddleware : Middleware<AppState> = {dispatch, appState, action, next ->
    if(action is CounterAction.Multiply){
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            delay(3000)
            repeat(40){
                dispatch(CounterAction.Increment)
            }

            delay(4000)
            dispatch(CounterAction.Multiply(appState.count * 500))
        }
    }
    next(appState, action, dispatch)
}

val loggerMiddleWare : Middleware<AppState> = { dispatch, appState, action, next ->
    Timber.d("""
        Action  $action dispatched
        ----------------------------
        App state: $appState
        ----------------------------
    """)
    next(appState, action, dispatch)
}