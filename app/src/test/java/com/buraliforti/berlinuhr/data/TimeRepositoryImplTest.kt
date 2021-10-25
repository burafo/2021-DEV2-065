package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.domain.TimeRepository
import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Test of [TimeRepositoryImpl]
 */
@ExtendWith(MockKExtension::class)
internal class TimeRepositoryImplTest {

    @MockK
    private lateinit var timeProvider: TimeProvider

    private lateinit var timeRepository: TimeRepository

    @BeforeEach
    fun setUp() {
        timeRepository = TimeRepositoryImpl(timeProvider)
    }

    @Test
    fun getCurrentTimeTest() {
        val entity = HoursMinutesSecondsEntity(
            hours = 0,
            minutes = 0,
            seconds = 0
        )
        every { timeProvider.getCurrentTime() } returns entity

        assertThat(timeRepository.getCurrentTime()).isEqualTo(entity)
    }

    @Test
    fun getCurrentMaxTimeTest() {
        val entity = HoursMinutesSecondsEntity(
            hours = 23,
            minutes = 59,
            seconds = 59
        )
        every { timeProvider.getCurrentTime() } returns entity

        assertThat(timeRepository.getCurrentTime()).isEqualTo(entity)
    }
}