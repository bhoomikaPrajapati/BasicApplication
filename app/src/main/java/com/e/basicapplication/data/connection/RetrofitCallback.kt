package com.e.basicapplication.data.connection

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import androidx.core.content.ContextCompat
import com.e.basicapplication.R
import com.e.basicapplication.base.App.Companion.appContext
import com.e.basicapplication.data.connection.response.ErrorData
import com.wang.avi.AVLoadingIndicatorView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Response


abstract class RetrofitCallback<T>(
    private val isShowProgressDialog: Boolean = true
) : ResponseCallBack<Response<T>>, Observer<Response<T>> {
    private var TAG = RetrofitCallback::class.java.simpleName
    private var progressDialog: Dialog? = null
    private var mDisposable: Disposable? = null

    init {
        progressDialog = appContext?.let { createProgressDialog(it) }
    }


    override fun onSubscribe(d: Disposable) {
        Log.e(TAG, "onSubscribe ")

        mDisposable = d
        isShowHideProgress(isShow = isShowProgressDialog)
    }

    override fun onNext(response: Response<T>) {
        isShowHideProgress(false)
        Log.e(TAG, "Next->$response")
        if (response.isSuccessful)
            onSuccess(response)
        else {
            onFailure(ErrorData().apply {
                message = response.message()
                statusCode = response.code()

            })
        }
    }

    override fun onError(e: Throwable) {


        isShowHideProgress(false)
        onFailure(ErrorData().apply {
            message = e.message
            error = e.printStackTrace()

        })
    }

    override fun onComplete() {
        Log.e(TAG, "onComplete ")
        isShowHideProgress(false)
        mDisposable?.dispose()
    }


    private fun isShowHideProgress(isShow: Boolean) {

        //    if ((appContext as Activity).isFinishing) return
        if (appContext != null && progressDialog != null) {
            if (isShow) {
                progressDialog?.show()
            } else {
                if (progressDialog?.isShowing == true)
                    progressDialog?.dismiss()
            }
        }
    }


    private fun createProgressDialog(context: Context): Dialog {
        val progressDialog = Dialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.app_loading_dialog, null, false)
        val avi: AVLoadingIndicatorView = view.findViewById(R.id.avi)
        avi.show()
        progressDialog.setContentView(view)
        val window: Window = progressDialog.window!!
        window.setBackgroundDrawable(context.let {
            ContextCompat.getDrawable(
                it,
                android.R.color.transparent
            )
        })
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        return progressDialog

    }


}
