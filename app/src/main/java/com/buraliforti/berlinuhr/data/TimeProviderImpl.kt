package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import javax.inject.Inject

/**
 * Implementation of [TimeProvider]
 */
class TimeProviderImpl @Inject constructor(private val systemCalendarWrapper: SystemCalendarWrapper) : TimeProvider {

    override fun getCurrentTime(): HoursMinutesSecondsEntity {
        val currentHours = systemCalendarWrapper.getHours()
        val currentMinutes = systemCalendarWrapper.getMinutes()
        val currentSeconds = systemCalendarWrapper.getSeconds()
        if (currentHours in 0..23 || currentMinutes in 0..59 || currentSeconds in 0..59) {
            return HoursMinutesSecondsEntity(
                hours = systemCalendarWrapper.getHours(),
                minutes = systemCalendarWrapper.getMinutes(),
                seconds = systemCalendarWrapper.getSeconds(),
            )
        } else {
            throw IllegalStateException("minutes and seconds must be in a range 0 to 59, hours - 0 to 23")
        }
    }
}