package com.e.basicapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager


/**
 * Created by bhoomika prajapati on 3/9/21.
 */
object AppUtils {


    fun isConnectedToInternet(context: Context?): Boolean {
        if (context != null) {
            val mgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mobileInfo = mgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            val wifiInfo = mgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            if (wifiInfo != null && wifiInfo.isAvailable && wifiInfo.isAvailable && wifiInfo.isConnected) {
                val wifiManager =
                    context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                val wifiInfoStatus = wifiManager.connectionInfo
                val supState = wifiInfoStatus.supplicantState
                if (supState.toString()
                        .equals("COMPLETED", ignoreCase = true) || supState.toString()
                        .equals("ASSOCIATED", ignoreCase = true)
                ) {
                    // WiFi is connected
                    return true
                }
            }
            // Mobile Network is connected
            return mobileInfo != null && mobileInfo.isAvailable && mobileInfo.isConnected
        }
        return false
    }
}
