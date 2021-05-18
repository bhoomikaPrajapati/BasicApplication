package com.e.basicapplication.data.connection

import com.e.basicapplication.data.connection.response.ErrorData

interface ResponseCallBack<T> {
    fun onSuccess(response: T)
    fun onFailure(error: ErrorData?)
}
