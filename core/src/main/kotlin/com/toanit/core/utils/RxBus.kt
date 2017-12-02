package com.toanit.core.utils


import io.reactivex.Flowable
import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor


class RxBus private constructor() {

    val mBus: FlowableProcessor<Any>

    init {
        mBus = PublishProcessor.create<Any>().toSerialized()
    }

    private object Holder {
        val instance = RxBus()
    }

    fun post(obj: Any) {
        mBus.onNext(obj)
    }

    fun <T> register(clz: Class<T>): Flowable<T> {

        return mBus.ofType(clz)
    }

    fun unregisterAll() {
        mBus.onComplete()
    }

    fun hasSubscribers(): Boolean {
        return mBus.hasSubscribers()
    }

    companion object {

        val instance: RxBus
            get() = Holder.instance
    }
}

