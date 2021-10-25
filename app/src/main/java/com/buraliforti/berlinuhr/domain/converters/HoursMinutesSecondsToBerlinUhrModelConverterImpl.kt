package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import javax.inject.Inject

/**
 * Implementation of [HoursMinutesSecondsToBerlinUhrModelConverter]
 */
class HoursMinutesSecondsToBerlinUhrModelConverterImpl @Inject constructor() :
    HoursMinutesSecondsToBerlinUhrModelConverter {

    override fun convert(from: HoursMinutesSecondsModel): BerlinUhrModel {
        val currentHours = from.hours
        val currentMinutes = from.minutes
        return BerlinUhrModel(
            secondsRowLightsOnCount = getSecondsRowLightsOnCount(from.seconds),
            multiHoursLightOnCount = getMultiHoursLightOnCount(currentHours),
            HoursLightOnCount = getHoursLightOnCount(currentHours),
            multiMinutesLightOnCount = getMultiMinutesLightOnCount(currentMinutes),
            minutesLightOnCount = getMinutesLightOnCount(currentMinutes)
        )
    }

    private fun getSecondsRowLightsOnCount(seconds: Int): Int {
        return when (seconds % 2 == 0) {
            true -> SECONDS_EVEN_SINGLE_LAMP_ON
            else -> SECONDS_ODD_SINGLE_LAMP_OFF
        }
    }

    private fun getMultiHoursLightOnCount(currentHours: Int): Int {
        return currentHours / MULTI_HOURS_ROW_VALUE
    }

    private fun getHoursLightOnCount(currentHours: Int): Int {
        return currentHours % MULTI_HOURS_ROW_VALUE
    }

    private fun getMultiMinutesLightOnCount(currentMinutes: Int): Int {
        return currentMinutes / MULTI_MINUTES_ROW_VALUE
    }

    private fun getMinutesLightOnCount(currentMinutes: Int): Int {
        return currentMinutes % MULTI_MINUTES_ROW_VALUE
    }

    companion object {
        /**
         * According to Berlin Uhr idea a single seconds lamp is ON if
         * current time seconds count is even.
         */
        private const val SECONDS_EVEN_SINGLE_LAMP_ON = 1

        /**
         * According to Berlin Uhr idea a single seconds lamp is OFF if
         * current time seconds count is odd.
         */
        private const val SECONDS_ODD_SINGLE_LAMP_OFF = 0

        /**
         * Value of a lamp at multiHours row - each lamp that is
         * turned on represents that amount of hours
         */
        private const val MULTI_HOURS_ROW_VALUE = 5

        /**
         * Value of a lamp at multiMinutes row - each lamp that is
         * turned on represents that amount of minutes
         */
        private const val MULTI_MINUTES_ROW_VALUE = 5
    }
}