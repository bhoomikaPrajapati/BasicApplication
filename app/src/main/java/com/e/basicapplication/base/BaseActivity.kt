package com.e.basicapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by bhoomika prajapati on 3/8/21.
 */
open class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}
