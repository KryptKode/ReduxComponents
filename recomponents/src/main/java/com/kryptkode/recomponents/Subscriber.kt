package com.kryptkode.recomponents

interface Subscriber<SelectedState> {
    fun newState(selectedState: SelectedState, dispatch: DispatchFunction)
    fun onUnsubscribed(dispatch: DispatchFunction)
}