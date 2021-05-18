package com.e.basicapplication.data.connection

interface SuccessCallBack<T> {
    fun onSuccess(response: T)
}