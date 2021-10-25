package com.buraliforti.berlinuhr.models.data

/**
 * Entity of time consisting of hours, minutes and seconds
 *
 * @param hours from 0 to 23
 * @param minutes from 0 to 59
 * @param seconds from 0 to 59
 */
data class HoursMinutesSecondsEntity(
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
)