package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import javax.inject.Inject

/**
 * Implementation of [TimeProvider]
 */
class TimeProviderImpl @Inject constructor(private val systemCalendarWrapper: SystemCalendarWrapper) : TimeProvider {

    override fun getCurrentTime(): HoursMinutesSecondsEntity {
        return HoursMinutesSecondsEntity(
            hours = systemCalendarWrapper.getHours(),
            minutes = systemCalendarWrapper.getMinutes(),
            seconds = systemCalendarWrapper.getSeconds(),
        )
    }
}