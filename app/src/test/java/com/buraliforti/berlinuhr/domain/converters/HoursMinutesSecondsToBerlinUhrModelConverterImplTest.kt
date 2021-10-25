package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Test of [HoursMinutesSecondsToBerlinUhrModelConverterImpl]
 */
internal class HoursMinutesSecondsToBerlinUhrModelConverterImplTest {

    private lateinit var converter: HoursMinutesSecondsToBerlinUhrModelConverter

    @BeforeEach
    fun setUp() {
        converter = HoursMinutesSecondsToBerlinUhrModelConverterImpl()
    }

    @Test
    fun convert_minTimeValue() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 0, minutes = 0, seconds = 0)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 1,
                multiHoursLightOnCount = 0,
                HoursLightOnCount = 0,
                multiMinutesLightOnCount = 0,
                minutesLightOnCount = 0
            ))
    }

    @Test
    fun convert_maxTimeValue() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 23, minutes = 59, seconds = 59)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 0,
                multiHoursLightOnCount = 4,
                HoursLightOnCount = 3,
                multiMinutesLightOnCount = 11,
                minutesLightOnCount = 4
            ))
    }

    @Test
    fun convert_CertainTime_12_56_01() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 12, minutes = 56, seconds = 1)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 0,
                multiHoursLightOnCount = 2,
                HoursLightOnCount = 2,
                multiMinutesLightOnCount = 11,
                minutesLightOnCount = 1
            ))
    }

    @Test
    fun convert_CertainTime_22_32_45() {
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 22, minutes = 32, seconds = 45)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 0,
                multiHoursLightOnCount = 4,
                HoursLightOnCount = 2,
                multiMinutesLightOnCount = 6,
                minutesLightOnCount = 2
            ))
    }

    @Test
    fun convert_CertainTime_16_50_06(){
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 16, minutes = 50, seconds = 6)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 1,
                multiHoursLightOnCount = 3,
                HoursLightOnCount = 1,
                multiMinutesLightOnCount = 10,
                minutesLightOnCount = 0
            ))
    }

    @Test
    fun convert_CertainTime_11_37_01(){
        assertThat(converter.convert(HoursMinutesSecondsModel(hours = 11, minutes = 37, seconds = 1)))
            .isEqualTo(BerlinUhrModel(
                secondsRowLightsOnCount = 0,
                multiHoursLightOnCount = 2,
                HoursLightOnCount = 1,
                multiMinutesLightOnCount = 7,
                minutesLightOnCount = 2
            ))
    }
}