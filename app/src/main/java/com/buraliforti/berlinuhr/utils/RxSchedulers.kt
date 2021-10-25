package com.buraliforti.berlinuhr.utils

import io.reactivex.Scheduler

/**
 * Interface for schedulers providers
 */
interface RxSchedulers {

    /**
     * @return [Scheduler] for Main thread
     */
    fun getMainThreadScheduler(): Scheduler

    /**
     * @return [Scheduler] for IO-bound work
     */
    fun getIOScheduler(): Scheduler

    /**
     * @return [Scheduler] for computation-bound work
     */
    fun getComputationScheduler(): Scheduler
}