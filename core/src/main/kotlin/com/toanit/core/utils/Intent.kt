/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.celites.kutils

import android.app.Activity
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment


public fun Context.flags(flag: Int, vararg flags: Int): Int {
    var orFlags = flag;
    for (i in flags) {
        orFlags = orFlags or i
    }
    return orFlags
}

inline public fun <reified T : Activity> Activity.startActivity(): Unit =
        this.startActivity(getIntent<T>())

inline public fun <reified T : Activity> Activity.startActivity(flags: Int): Unit =
        this.startActivity(getIntent<T>(flags))

inline public fun <reified T : Activity> Activity.startActivity(extras: Bundle): Unit =
        this.startActivity(getIntent<T>(extras = extras))

inline public fun <reified T : Activity> Activity.startActivity(flags: Int, extras: Bundle): Unit =
        this.startActivity(getIntent<T>(flags, extras))

inline public fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int): Unit =
        this.startActivityForResult(getIntent<T>(), requestCode)

inline public fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int,
                                                                         flags: Int): Unit =
        this.startActivityForResult(getIntent<T>(flags), requestCode)

inline public fun <reified T : Activity> Activity.startActivityForResult(
        extras: Bundle, requestCode: Int): Unit =
        this.startActivityForResult(getIntent<T>(extras = extras), requestCode)

inline public fun <reified T : Activity> Activity.startActivityForResult(
        extras: Bundle, requestCode: Int, flags: Int): Unit =
        this.startActivityForResult(getIntent<T>(flags, extras), requestCode)

inline public fun <reified T : Activity> Service.startActivity(): Unit =
        this.startActivity(getIntent<T>(Intent.FLAG_ACTIVITY_NEW_TASK))

inline public fun <reified T : Activity> Service.startActivity(flags: Int): Unit =
        this.startActivity(getIntent<T>(flags))

inline public fun <reified T : Activity> Service.startActivity(extras: Bundle): Unit =
        this.startActivity(getIntent<T>(Intent.FLAG_ACTIVITY_NEW_TASK, extras))

inline public fun <reified T : Activity> Service.startActivity(extras: Bundle, flags: Int): Unit =
        this.startActivity(getIntent<T>(flags, extras))

inline public fun <reified T : Service> Context.startService(): ComponentName =
        this.startService(getIntent<T>())

inline public fun <reified T : Service> Context.startService(flags: Int): ComponentName =
        this.startService(getIntent<T>(flags))

inline public fun <reified T : Service> Context.startService(extras: Bundle): ComponentName =
        this.startService(getIntent<T>(extras = extras))

inline public fun <reified T : Service> Context.startService(extras: Bundle,
                                                             flags: Int): ComponentName = this.startService(getIntent<T>(flags, extras))

inline public fun <reified T : Activity> Fragment.startActivity(): Unit =
        this.startActivity(getIntent<T>())

inline public fun <reified T : Context> Fragment.getIntent(): Intent =
        Intent(context, T::class.java)

inline public fun <reified T : Context> Context.getIntent(): Intent =
        Intent(this, T::class.java)

inline public fun <reified T : Context> Context.getIntent(flags: Int): Intent {
    val intent = getIntent<T>()
    intent.setFlags(flags)
    return intent
}


inline public fun <reified T : Context> Context.getIntent(flags: Int = 0, extras: Bundle): Intent {
    val intent = getIntent<T>(flags)
    intent.putExtras(extras)
    return intent
}
