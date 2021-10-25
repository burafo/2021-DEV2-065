package com.buraliforti.berlinuhr.domain

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity

/**
 * Provides current time entity from one of available sources (e.g. system (device) time, web api etc.)
 */
interface TimeRepository {

    /**
     * Provide a current time entity
     *
     * @return current time entity
     */
    fun getCurrentTime(): HoursMinutesSecondsEntity
}