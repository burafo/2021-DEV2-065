package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.R
import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShape
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShapeColorModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Test of [BerlinUhrModelToBerlinUhrShapeColorModelConverterImpl]
 */
internal class BerlinUhrModelToBerlinUhrShapeColorModelConverterImplTest {

    private lateinit var converter: BerlinUhrModelToBerlinUhrShapeColorModelConverter

    @BeforeEach
    fun setUp() {
        converter = BerlinUhrModelToBerlinUhrShapeColorModelConverterImpl()
    }

    @Test
    fun convert_AllLampsOff() {
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 0,
            multiHoursLightOnCount = 0,
            HoursLightOnCount = 0,
            multiMinutesLightOnCount = 0,
            minutesLightOnCount = 0)))
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
                minutesRowLamps = listOf(whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff)
            ))
    }

    @Test
    fun convert_MaxLampsOn() {
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 1,
            multiHoursLightOnCount = 4,
            HoursLightOnCount = 3,
            multiMinutesLightOnCount = 11,
            minutesLightOnCount = 4)))
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
    fun convert_CertainTime_12_56_01() {
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 0,
            multiHoursLightOnCount = 2,
            HoursLightOnCount = 2,
            multiMinutesLightOnCount = 11,
            minutesLightOnCount = 1)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(whiteCircleLampOff),
                multiHoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                hoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
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
                    yellowRectangleLampOn),
                minutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff)
            ))
    }

    @Test
    fun convert_CertainTime_22_32_45() {
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 0,
            multiHoursLightOnCount = 4,
            HoursLightOnCount = 2,
            multiMinutesLightOnCount = 6,
            minutesLightOnCount = 2)))
            .isEqualTo(BerlinUhrShapeColorModel(
                secondsRowLamps = listOf(whiteCircleLampOff),
                multiHoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn,
                    redRectangleLampOn),
                hoursRowLamps = listOf(
                    redRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff,
                    whiteRectangleLampOff),
                multiMinutesRowLamps = listOf(
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    yellowRectangleLampOn,
                    yellowRectangleLampOn,
                    redRectangleLampOn,
                    whiteRectangleLampOff,
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

    @Test
    fun convert_CertainTime_16_50_06() {
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 1,
            multiHoursLightOnCount = 3,
            HoursLightOnCount = 1,
            multiMinutesLightOnCount = 10,
            minutesLightOnCount = 0)))
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
        assertThat(converter.convert(BerlinUhrModel(
            secondsRowLightsOnCount = 0,
            multiHoursLightOnCount = 2,
            HoursLightOnCount = 1,
            multiMinutesLightOnCount = 7,
            minutesLightOnCount = 2)))
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