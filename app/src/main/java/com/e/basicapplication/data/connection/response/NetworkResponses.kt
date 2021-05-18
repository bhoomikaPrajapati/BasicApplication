package com.e.basicapplication.data.connection.response

sealed class NetworkResponses {

    open class Responses<T>(
        var isSuccess: Boolean = false,
        var message: String = "",
        val statusCode: Int = 0,
        var data: T?,

        )

    open class Login :
        Responses<ResponseData.LoginResponse>(data = ResponseData.LoginResponse())


}