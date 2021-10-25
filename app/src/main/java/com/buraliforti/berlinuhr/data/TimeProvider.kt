package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity

/**
 * Provider of system time data
 */
//ToDo Check if this interface is really needed for future scalability of code
interface TimeProvider {

    /**
     * Get current local time in [HoursMinutesSecondsEntity] form
     */
    fun getCurrentTime(): HoursMinutesSecondsEntity
}