package com.e.basicapplication.domain.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.e.basicapplication.data.connection.RetrofitCallback
import com.e.basicapplication.data.connection.SuccessCallBack
import com.e.basicapplication.data.connection.response.ErrorData
import com.e.basicapplication.data.connection.response.NetworkResponses
import com.e.basicapplication.data.connection.response.ResponseData
import com.e.basicapplication.domain.ApiRepository
import retrofit2.Response

class LoginVM : ViewModel() {
    var apiRepository = ApiRepository()

    fun callLoginApi(
        map: HashMap<String, String>,
        responseCallBack: SuccessCallBack<ResponseData.LoginResponse>
    ) {
        apiRepository.callLoginApi(map, object : RetrofitCallback<NetworkResponses.Login>() {
            override fun onSuccess(response: Response<NetworkResponses.Login>) {
                Log.e("Response", response.message())
                response.body()?.data?.let { responseCallBack.onSuccess(it) }
            }

            override fun onFailure(error: ErrorData?) {
            }
        })
    }
}