package com.e.basicapplication.domain

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.e.basicapplication.R
import com.e.basicapplication.base.BaseFragment

open class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            navigateTo(destId = R.id.action_splashFragment_to_loginFragment)
        }, 2000)
    }

}




