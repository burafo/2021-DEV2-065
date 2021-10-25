package com.buraliforti.berlinuhr.utils

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject

/**
 * Implementation of [RxSchedulers]
 */
class RxSchedulersImpl @Inject constructor() : RxSchedulers {

    override fun getMainThreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread();
    }

    override fun getIOScheduler(): Scheduler {
        return Schedulers.io();
    }

    override fun getComputationScheduler(): Scheduler {
        return Schedulers.computation();
    }
}