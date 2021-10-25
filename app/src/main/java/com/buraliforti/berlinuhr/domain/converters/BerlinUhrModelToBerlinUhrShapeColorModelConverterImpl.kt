package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.R
import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShape
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShape.RECTANGLE
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShapeColorModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import javax.inject.Inject

/**
 * Implementation of [BerlinUhrModelToBerlinUhrShapeColorModelConverter]
 */
class BerlinUhrModelToBerlinUhrShapeColorModelConverterImpl @Inject constructor() :
    BerlinUhrModelToBerlinUhrShapeColorModelConverter {

    /**
     * @param from model of Berlin Uhr in the form of 5 rows of lights
     *
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    override fun convert(from: BerlinUhrModel): BerlinUhrShapeColorModel {
        return BerlinUhrShapeColorModel(
            secondsRowLamps = getSecondsRowLamps(from.secondsRowLightsOnCount),
            multiHoursRowLamps = getMultiHoursRowLamps(from.multiHoursLightOnCount),
            hoursRowLamps = getHoursRowLamps(from.HoursLightOnCount),
            multiMinutesRowLamps = getMultiMinutesRowLamps(from.multiMinutesLightOnCount),
            minutesRowLamps = getMinutesRowLamps(from.minutesLightOnCount)
        )
    }

    private fun getSecondsRowLamps(secondsRowLightsOnCount: Int): List<BerlinUhrLampShapeColorModel> {
        return when (secondsRowLightsOnCount == SECONDS_LAMPS_MAX_COUNT) {
            true -> listOf(yellowCircleLampOn)
            else -> listOf(yellowCircleLampOff)
        }
    }

    private fun getMultiHoursRowLamps(multiHoursLightOnCount: Int): List<BerlinUhrLampShapeColorModel> {
        val turnedOnLamps = listOf((0 until multiHoursLightOnCount)).flatten().map { redRectangleLampOn }
        val turnedOffLampsCount = MULTI_HOURS_LAMPS_MAX_COUNT - multiHoursLightOnCount
        val turnedOffLamps = listOf((0 until turnedOffLampsCount)).flatten().map { rectangleLampOff }
        return turnedOnLamps + turnedOffLamps
    }

    private fun getHoursRowLamps(hoursLightOnCount: Int): List<BerlinUhrLampShapeColorModel> {
        val turnedOnLamps = listOf((0 until hoursLightOnCount)).flatten().map { redRectangleLampOn }
        val turnedOffLampsCount = HOURS_LAMPS_MAX_COUNT - hoursLightOnCount
        val turnedOffLamps = listOf((0 until turnedOffLampsCount)).flatten().map { rectangleLampOff }
        return turnedOnLamps + turnedOffLamps
    }

    private fun getMultiMinutesRowLamps(multiMinutesLightOnCount: Int): List<BerlinUhrLampShapeColorModel> {
        val turnedOnLamps = listOf((0 until multiMinutesLightOnCount)).flatten().map {
            when {
                // every third lamp in this row
                (it + 1) % 3 == 0 -> redRectangleLampOn
                else -> yellowRectangleLampOn
            }
        }
        val turnedOffLampsCount = MULTI_MINUTES_LAMPS_MAX_COUNT - multiMinutesLightOnCount
        val turnedOffLamps = listOf((0 until turnedOffLampsCount)).flatten().map { rectangleLampOff }
        return turnedOnLamps + turnedOffLamps
    }

    private fun getMinutesRowLamps(minutesLightOnCount: Int): List<BerlinUhrLampShapeColorModel> {
        val turnedOnLamps = listOf((0 until minutesLightOnCount)).flatten().map { yellowRectangleLampOn }
        val turnedOffLampsCount = MINUTES_LAMPS_MAX_COUNT - minutesLightOnCount
        val turnedOffLamps = listOf((0 until turnedOffLampsCount)).flatten().map { rectangleLampOff }
        return turnedOnLamps + turnedOffLamps
    }

    private val redRectangleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.red, shape = RECTANGLE, isLampOn = true
    )

    private val yellowRectangleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.yellow, shape = RECTANGLE, isLampOn = true
    )

    private val rectangleLampOff = BerlinUhrLampShapeColorModel(
        color = R.color.white, shape = RECTANGLE, isLampOn = false
    )

    private val yellowCircleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.yellow, shape = BerlinUhrLampShape.CIRCLE, isLampOn = true
    )

    private val yellowCircleLampOff = BerlinUhrLampShapeColorModel(
        color = R.color.white, shape = BerlinUhrLampShape.CIRCLE, isLampOn = false
    )

    companion object {
        /**
         * Maximum number of lamps representing seconds time data
         */
        private const val SECONDS_LAMPS_MAX_COUNT = 1

        /**
         * Maximum number of lamps representing multiHours time data
         */
        private const val MULTI_HOURS_LAMPS_MAX_COUNT = 4

        /**
         * Maximum number of lamps representing hours time data
         */
        private const val HOURS_LAMPS_MAX_COUNT = 4

        /**
         * Maximum number of lamps representing multiMinutes time data
         */
        private const val MULTI_MINUTES_LAMPS_MAX_COUNT = 11

        /**
         * Maximum number of lamps representing minutes time data
         */
        private const val MINUTES_LAMPS_MAX_COUNT = 4
    }
}