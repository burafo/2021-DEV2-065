package com.buraliforti.berlinuhr.data

import java.lang.IllegalStateException
import java.util.Calendar
import javax.inject.Inject

/**
 * Model of time consisting of hours, minutes and seconds
 * Hours from 0 to 23
 * Minutes from 0 to 59
 * Seconds from 0 to 59
 */
// ToDo add tests
class SystemCalendarWrapperImpl @Inject constructor() : SystemCalendarWrapper {

    override fun getHours(): Int {
        val hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (hours in 0..23) {
            return hours
        } else {
            throw IllegalStateException("hours must be in the range of 0 to 23")
        }
    }

    override fun getMinutes(): Int {
        val minutes = Calendar.getInstance().get(Calendar.MINUTE)
        if (minutes in 0..59) {
            return minutes
        } else {
            throw IllegalStateException("minutes must be in the range of 0 to 59")
        }
    }

    override fun getSeconds(): Int {
        val seconds = Calendar.getInstance().get(Calendar.SECOND)
        if (seconds in 0..59) {
            return seconds
        } else {
            throw IllegalStateException("seconds must be in the range of 0 to 59")
        }
    }
}