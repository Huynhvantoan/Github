package com.toanit.core.utils

import android.app.Activity
import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/**
 * Created by aidchow on 17-5-29.
 */


object SnackBarUtils {
    fun showSnackBar(v: View?, snackbarText: String?) {
        if (v == null || snackbarText == null) {
            return
        }
        Snackbar.make(v, snackbarText, Snackbar.LENGTH_LONG).show()
    }

    fun Context.showToast(@StringRes text: Int) = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()

    fun Activity.showToast(msg:String) {
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }

    fun Activity.showToast(@StringRes msgId:Int) {
        Toast.makeText(applicationContext,msgId, Toast.LENGTH_SHORT).show()
    }
}