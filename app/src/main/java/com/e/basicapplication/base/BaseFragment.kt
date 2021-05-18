package com.e.basicapplication.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.e.basicapplication.R

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    protected fun navigateTo(navId: Int = R.id.home_main_nav, destId: Int) {
        activity?.let {
            Navigation.findNavController(it, navId)
                .navigate(destId)
        }
    }

    protected fun navigateWithArgsTo(navId: Int = R.id.home_main_nav, destId: Int, args: Bundle) {
        activity?.let {
            Navigation.findNavController(it, navId)
                .navigate(destId, args)
        }
    }

    protected fun navigateToDrawerMenu(drawerMenuId: Int) {
        findNavController().popBackStack().also {
            findNavController().navigate(drawerMenuId)
        }
    }

}