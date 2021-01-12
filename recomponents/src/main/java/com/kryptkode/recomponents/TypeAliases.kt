package com.kryptkode.recomponents

typealias DispatchFunction = (Action) -> Unit

typealias Middleware<State> = (DispatchFunction, State, Action, Next<State>) -> Action

typealias Next<State> = (State, Action, DispatchFunction) -> Action

typealias Reducer<State> = (Action, State) -> State