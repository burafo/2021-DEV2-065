package com.buraliforti.berlinuhr.domain

import com.buraliforti.berlinuhr.domain.converters.BerlinUhrModelToBerlinUhrShapeColorModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsEntityToModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrModelConverter
import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
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
 * Test of [BerlinUhrInteractorImpl]
 */
@ExtendWith(MockKExtension::class)
internal class BerlinUhrInteractorImplTest {

    @MockK
    private lateinit var timeRepository: TimeRepository

    @MockK
    private lateinit var toHoursMinutesSecondsModelConverter: HoursMinutesSecondsEntityToModelConverter

    @MockK
    private lateinit var toBerlinUhrModelConverter: HoursMinutesSecondsToBerlinUhrModelConverter

    @MockK
    private lateinit var toBerlinUhrShapeColorModelConverter: BerlinUhrModelToBerlinUhrShapeColorModelConverter

    @MockK
    private lateinit var entity: HoursMinutesSecondsEntity

    @MockK
    private lateinit var hoursMinutesSecondsModel: HoursMinutesSecondsModel

    @MockK
    private lateinit var berlinUhrModel: BerlinUhrModel

    @MockK
    private lateinit var berlinUhrShapeColorModel: BerlinUhrShapeColorModel

    private lateinit var interactor: BerlinUhrInteractor

    @BeforeEach
    fun setUp() {
        interactor = BerlinUhrInteractorImpl(timeRepository,
            toHoursMinutesSecondsModelConverter,
            toBerlinUhrModelConverter,
            toBerlinUhrShapeColorModelConverter)
    }

    @Test
    fun getBerlinUhrShapeColorModel() {
        every { timeRepository.getCurrentTime() } returns entity
        every { toHoursMinutesSecondsModelConverter.convert(entity) } returns hoursMinutesSecondsModel
        every { toBerlinUhrModelConverter.convert(hoursMinutesSecondsModel) } returns berlinUhrModel
        every { toBerlinUhrShapeColorModelConverter.convert(berlinUhrModel) } returns berlinUhrShapeColorModel

        assertThat(interactor.getBerlinUhrShapeColorModel()).isEqualTo(berlinUhrShapeColorModel)
    }
}