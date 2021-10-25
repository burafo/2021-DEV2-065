package com.buraliforti.berlinuhr.presentation

import androidx.lifecycle.Observer
import com.buraliforti.berlinuhr.domain.BerlinUhrInteractor
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import com.buraliforti.berlinuhr.utils.InstantExecutorExtension
import com.buraliforti.berlinuhr.utils.RxSchedulersTestImpl
import io.mockk.called
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.concurrent.TimeUnit

/**
 * Test of [BerlinUhrViewModel]
 */
@ExtendWith(MockKExtension::class, InstantExecutorExtension::class)
class BerlinUhrViewModelTest {

    @MockK(relaxed = true)
    private lateinit var berlinUhrScreenObserver: Observer<BerlinUhrShapeColorModel?>

    @MockK
    private lateinit var interactor: BerlinUhrInteractor

    private val rxSchedulersTest = RxSchedulersTestImpl()

    private lateinit var viewModel: BerlinUhrViewModel

    @BeforeEach
    fun setup() {
        viewModel = BerlinUhrViewModel(interactor, rxSchedulersTest)
    }

    @Test
    fun getBerlinUhrScreenLiveData_NoTimePassed() {
        every { interactor.getBerlinUhrShapeColorModel() } returns mockk()

        viewModel.getBerlinUhrScreenLiveData().observeForever(berlinUhrScreenObserver)
        verify { berlinUhrScreenObserver wasNot called }
    }

    @Test
    fun getBerlinUhrScreenLiveData_SecondPassed() {
        val modelMock: BerlinUhrShapeColorModel = mockk()
        every { interactor.getBerlinUhrShapeColorModel() } returns modelMock

        viewModel.getBerlinUhrScreenLiveData().observeForever(berlinUhrScreenObserver)
        rxSchedulersTest.testScheduler.advanceTimeBy(1, TimeUnit.SECONDS)
        verify { berlinUhrScreenObserver.onChanged(modelMock) }
    }
}