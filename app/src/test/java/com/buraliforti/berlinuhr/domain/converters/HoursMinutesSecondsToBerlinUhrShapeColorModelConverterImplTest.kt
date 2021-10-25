package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.R
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShape
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShapeColorModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Test of [HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl]
 */
internal class HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImplTest {

    private lateinit var converter: HoursMinutesSecondsToBerlinUhrShapeColorModelConverter

    @BeforeEach
    fun setUp() {
        converter = HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl()
    }

    @Test
    fun convert_minTimeValue() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 0, minutes = 0, seconds = 0)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(whiteCircleLampOff),
                multiHoursRowLamps = listOf(
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                hoursRowLamps = listOf(
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                multiMinutesRowLamps = listOf(
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                minutesRowLamps = listOf(
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff)
            ))
    }

    @Test
    fun convert_MaxTimeValue() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 23, minutes = 59, seconds = 59)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(yellowCircleLampOn),
                multiHoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn),
                hoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff),
                multiMinutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn),
                minutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn)
            ))
    }

    @Test
    fun convert_CertainTime_16_50_06() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 16, minutes = 50, seconds = 6)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(yellowCircleLampOn),
                multiHoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff),
                hoursRowLamps = listOf(
                    redRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                multiMinutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    whiteRectangleLampOff),
                minutesRowLamps = listOf(
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff)
            ))
    }

    @Test
    fun convert_CertainTime_11_37_01() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 11, minutes = 37, seconds = 1)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(whiteCircleLampOff),
                multiHoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                hoursRowLamps = listOf(
                    redRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                multiMinutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                minutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff)
            ))
    }

    private val redRectangleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.red, shape = BerlinUhrLampShape.RECTANGLE, isLampOn = true
    )

    private val yellowRectangleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.yellow, shape = BerlinUhrLampShape.RECTANGLE, isLampOn = true
    )

    private val whiteRectangleLampOff = BerlinUhrLampShapeColorModel(
        color = R.color.white, shape = BerlinUhrLampShape.RECTANGLE, isLampOn = false
    )

    private val yellowCircleLampOn = BerlinUhrLampShapeColorModel(
        color = R.color.yellow, shape = BerlinUhrLampShape.CIRCLE, isLampOn = true
    )

    private val whiteCircleLampOff = BerlinUhrLampShapeColorModel(
        color = R.color.white, shape = BerlinUhrLampShape.CIRCLE, isLampOn = false
    )
}