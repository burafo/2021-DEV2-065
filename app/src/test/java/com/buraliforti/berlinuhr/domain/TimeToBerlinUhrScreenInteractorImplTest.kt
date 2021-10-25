package com.buraliforti.berlinuhr.domain

import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrShapeColorModelConverter
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
 * Test of [TimeToBerlinUhrScreenInteractorImpl]
 */
@ExtendWith(MockKExtension::class)
internal class TimeToBerlinUhrScreenInteractorImplTest {

    @MockK
    private lateinit var converter: HoursMinutesSecondsToBerlinUhrShapeColorModelConverter

    @MockK
    private lateinit var hoursMinutesSecondsModel: HoursMinutesSecondsModel

    @MockK
    private lateinit var berlinUhrShapeColorModel: BerlinUhrShapeColorModel

    private lateinit var interactor: TimeToBerlinUhrScreenInteractor

    @BeforeEach
    fun setUp() {
        interactor = TimeToBerlinUhrScreenInteractorImpl(converter)
    }

    @Test
    fun getBerlinUhrShapeColorModelFromInputTime() {
        every { converter.convert(hoursMinutesSecondsModel) } returns berlinUhrShapeColorModel

        assertThat(interactor.getBerlinUhrShapeColorModelFromInputTime(hoursMinutesSecondsModel))
            .isEqualTo(berlinUhrShapeColorModel)
    }
}