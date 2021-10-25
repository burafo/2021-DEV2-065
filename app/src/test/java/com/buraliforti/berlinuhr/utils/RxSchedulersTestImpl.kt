package com.buraliforti.berlinuhr.utils

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Implementation of [RxSchedulers] for tests
 */
class RxSchedulersTestImpl : RxSchedulers {

    internal val testScheduler = TestScheduler()

    fun getTestScheduler(): TestScheduler {
        return testScheduler
    }

    override fun getMainThreadScheduler(): Scheduler {
        return testScheduler
    }

    override fun getIOScheduler(): Scheduler {
        return testScheduler
    }

    override fun getComputationScheduler(): Scheduler {
        return testScheduler
    }

}