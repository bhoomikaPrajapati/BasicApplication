package com.e.basicapplication.data.connection

import com.e.basicapplication.data.connection.response.NetworkResponses
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST(LOGIN)
    fun login(@Body map: HashMap<String, String>): Observable<Response<NetworkResponses.Login>>


}
