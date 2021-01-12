package com.kryptkode.recomponents

import android.os.Handler
import android.os.Looper

val mainThreadHandler by lazy { Handler(Looper.getMainLooper()) }

fun assertOnMainThread() {
    check(Looper.myLooper() == Looper.getMainLooper()) {
        "Not on main thread when we should be."
    }
}