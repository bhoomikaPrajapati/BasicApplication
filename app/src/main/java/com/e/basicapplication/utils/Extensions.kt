package com.e.basicapplication.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

/**
 * Created by bhoomika prajapati on 3/8/21.
 */


fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun <T> Context.openActivity(it: Class<T>) {
    val intent = Intent(this, it)
    startActivity(intent)
}

fun Context.toast(message: CharSequence?) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()





