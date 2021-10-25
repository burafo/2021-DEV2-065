package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.domain.TimeRepository
import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import javax.inject.Inject

/**
 * Implementation of [TimeRepository]
 */
class TimeRepositoryImpl@Inject constructor(
    private val timeProvider: TimeProvider
) : TimeRepository {

    override fun getCurrentTime(): HoursMinutesSecondsEntity {
        return timeProvider.getCurrentTime()
    }
}