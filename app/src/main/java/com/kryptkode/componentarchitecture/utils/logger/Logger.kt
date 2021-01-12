package com.kryptkode.componentarchitecture.utils.logger

/**
 * Created by kryptkode on 5/21/2020.
 */
interface Logger {
    fun d(message: String, vararg objects: Any)
    fun d(throwable: Throwable, message: String, vararg objects: Any)
    fun i(message: String, vararg objects: Any)
    fun i(throwable: Throwable, message: String, vararg objects: Any)
    fun w(message: String, vararg objects: Any)
    fun w(throwable: Throwable, message: String, vararg objects: Any)
    fun e(message: String, vararg objects: Any)
    fun e(throwable: Throwable, message: String, vararg objects: Any)
}