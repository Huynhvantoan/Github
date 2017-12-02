package com.toanit.core.react

import io.reactivex.Scheduler

/**
 * Created by Toan.IT on 6/19/17.
 * Email: huynhvantoan.itc@gmail.com
 */

interface RxSchedulers {

    fun diskIO(): Scheduler

    fun mainThread(): Scheduler

    fun computation(): Scheduler

    fun networkIO(): Scheduler
}