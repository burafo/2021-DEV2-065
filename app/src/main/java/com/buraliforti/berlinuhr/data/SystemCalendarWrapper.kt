package com.buraliforti.berlinuhr.data

/**
 * Wrapper of system Calendar and its hours, minutes, seconds methods
 *
 * Hours from 0 to 23
 * Minutes from 0 to 59
 * Seconds from 0 to 59
 */
interface SystemCalendarWrapper {

    /**
     * Provide current system hours in 0 to 23 format
     */
    fun getHours(): Int

    /**
     * Provide current system hours in 0 to 59 format
     */
    fun getMinutes(): Int

    /**
     * Provide current system seconds in 0 to 59 format
     */
    fun getSeconds(): Int
}