package com.toanit.core.utils

import android.os.Build

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

fun supportsKitKat(code: () -> Unit) {
    supportsVersion(code, 19)
}

fun supportsLollipop(code: () -> Unit) {
    supportsVersion(code, 21)
}

private fun supportsVersion(code: () -> Unit, sdk: Int) {
    if (Build.VERSION.SDK_INT >= sdk) {
        code.invoke()
    }
}