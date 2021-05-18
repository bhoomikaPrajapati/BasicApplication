package com.e.basicapplication.domain.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.e.basicapplication.R
import com.e.basicapplication.base.BaseFragment
import com.e.basicapplication.data.connection.EMAIL
import com.e.basicapplication.data.connection.PASSWORD
import com.e.basicapplication.data.connection.SuccessCallBack
import com.e.basicapplication.data.connection.response.ResponseData
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val loginVM by lazy { ViewModelProvider(this).get(LoginVM::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
        listener()
    }

    private fun listener() {
        btn_login.setOnClickListener {
            callLoginApi()
        }
    }

    private fun callLoginApi() {
        val map = HashMap<String, String>()
        map[EMAIL] = "playertest01@getnada.com"
        map[PASSWORD] = "123456"
        loginVM.callLoginApi(map, object : SuccessCallBack<ResponseData.LoginResponse> {
            override fun onSuccess(response: ResponseData.LoginResponse) {
                navigateTo(destId = R.id.action_loginFragment_to_homeFragment)
            }

        })

    }

    private fun initialization() {


    }

}