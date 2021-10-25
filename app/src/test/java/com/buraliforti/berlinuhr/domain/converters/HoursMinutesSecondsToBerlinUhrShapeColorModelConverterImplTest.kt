package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Test of [HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl]
 */
@ExtendWith(MockKExtension::class)
internal class HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImplTest {

    @MockK
    private lateinit var toBerlinUhrModelConverter: HoursMinutesSecondsToBerlinUhrModelConverter

    @MockK
    private lateinit var toBerlinUhrShapeColorModelConverter: BerlinUhrModelToBerlinUhrShapeColorModelConverter

    @MockK
    private lateinit var hoursMinutesSecondsModel: HoursMinutesSecondsModel

    @MockK
    private lateinit var berlinUhrModel: BerlinUhrModel

    @MockK
    private lateinit var berlinUhrShapeColorModel: BerlinUhrShapeColorModel

    private lateinit var converter: HoursMinutesSecondsToBerlinUhrShapeColorModelConverter

    @BeforeEach
    fun setUp() {
        converter = HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl(
            toBerlinUhrModelConverter = toBerlinUhrModelConverter,
            toBerlinUhrShapeColorModelConverter = toBerlinUhrShapeColorModelConverter)
    }

    @Test
    fun convert() {
        every { toBerlinUhrModelConverter.convert(hoursMinutesSecondsModel) } returns berlinUhrModel
        every { toBerlinUhrShapeColorModelConverter.convert(berlinUhrModel) } returns berlinUhrShapeColorModel

        assertThat(converter.convert(hoursMinutesSecondsModel))
            .isEqualTo(berlinUhrShapeColorModel)
    }
}