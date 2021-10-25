package com.buraliforti.berlinuhr.data

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class TimeProviderImplTest {

    @MockK
    private lateinit var systemTime: SystemCalendarWrapper

    private lateinit var timeProvider: TimeProvider

    @BeforeEach
    fun setUp() {
        timeProvider = TimeProviderImpl(systemTime)
    }

    @Test
    fun getCurrentTime_MinimalTime() {
        every { systemTime.getHours() } returns 0
        every { systemTime.getMinutes() } returns 0
        every { systemTime.getSeconds() } returns 0
        assertThat(timeProvider.getCurrentTime()).isEqualTo(HoursMinutesSecondsEntity(
            hours = 0,
            minutes = 0,
            seconds = 0
        ))
    }

    @Test
    fun getCurrentTime_MaximumTime() {
        every { systemTime.getHours() } returns 23
        every { systemTime.getMinutes() } returns 59
        every { systemTime.getSeconds() } returns 59
        assertThat(timeProvider.getCurrentTime()).isEqualTo(HoursMinutesSecondsEntity(
            hours = 23,
            minutes = 59,
            seconds = 59
        ))
    }
}