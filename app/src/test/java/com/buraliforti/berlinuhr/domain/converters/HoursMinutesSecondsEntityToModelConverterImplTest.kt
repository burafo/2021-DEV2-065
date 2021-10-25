package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.google.common.truth.Truth.assertThat
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Test of [HoursMinutesSecondsEntityToModelConverterImpl]
 */
@ExtendWith(MockKExtension::class)
internal class HoursMinutesSecondsEntityToModelConverterImplTest {

    private lateinit var converter: HoursMinutesSecondsEntityToModelConverter

    @BeforeEach
    fun setUp() {
        converter = HoursMinutesSecondsEntityToModelConverterImpl()
    }

    @Test
    fun convert_minimalTimeValues() {
        val entity = HoursMinutesSecondsEntity(hours = 0, minutes = 0, seconds = 0)

        assertThat(converter.convert(entity)).isEqualTo(HoursMinutesSecondsModel(hours = 0, minutes = 0, seconds = 0))
    }

    @Test
    fun convert_maximumTimeValues() {
        val entity = HoursMinutesSecondsEntity(hours = 23, minutes = 59, seconds = 59)

        assertThat(converter.convert(entity)).isEqualTo(HoursMinutesSecondsModel(
            hours = 23,
            minutes = 59,
            seconds = 59))
    }
}