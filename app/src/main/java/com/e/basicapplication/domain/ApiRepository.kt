package com.e.basicapplication.domain


import com.e.basicapplication.data.connection.ApiClient
import com.e.basicapplication.data.connection.ApiService
import com.e.basicapplication.data.connection.RetrofitCallback
import com.e.basicapplication.data.connection.response.NetworkResponses
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


open class ApiRepository {
    private var api: ApiService? = null

    init {
        api = ApiClient.getService()
    }

    fun callLoginApi(
        map: HashMap<String, String>,
        responseCallBack: RetrofitCallback<NetworkResponses.Login>
    ) {
        ApiClient.getServiceWithoutHeader()?.login(map)
            ?.observable()
            ?.subscribe(responseCallBack)
    }


    fun callLoginApi(
        map: HashMap<String, String>
    ): Observable<Response<NetworkResponses.Login>>? {
        return ApiClient.getServiceWithoutHeader()?.login(map)
    }

    /*object : RetrofitCallback<NetworkResponses.Login>() {
                override fun onSuccess(response: Response<NetworkResponses.Login>) {
                    response.body()?.data?.let { responseCallBack.onSuccess(it) }
                }
                override fun onFailure(error: ErrorData?) {
                    responseCallBack.onFailure(error)
                }

            }*/

}


private fun <T> Observable<T>.observable(): Observable<T> {
    return observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
}

