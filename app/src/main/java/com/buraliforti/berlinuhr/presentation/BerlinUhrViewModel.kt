package com.buraliforti.berlinuhr.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.buraliforti.berlinuhr.domain.BerlinUhrInteractor
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import com.buraliforti.berlinuhr.utils.RxSchedulers
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * [ViewModel] for BerlinUhr screen
 *
 * @param interactor Interactor that is responsible for preparing [BerlinUhrShapeColorModel] for presentation layer
 */
@HiltViewModel
class BerlinUhrViewModel @Inject constructor(
    private val interactor: BerlinUhrInteractor,
    private val rxSchedulers: RxSchedulers
) : ViewModel() {

    private val berlinUhrLiveData: LiveData<BerlinUhrShapeColorModel?> = getBerlinUhrModels().toLiveData()

    /**
     * @return [LiveData] for seconds light
     */
    fun getBerlinUhrScreenLiveData() = berlinUhrLiveData

    private fun getBerlinUhrModels(): Flowable<BerlinUhrShapeColorModel> {
        return Flowable.interval(DELAY, TimeUnit.MILLISECONDS, rxSchedulers.getComputationScheduler())
            .map { interactor.getBerlinUhrShapeColorModel() }
            .distinctUntilChanged()
            .replay(1).refCount();
    }

    companion object {
        /**
         * Delay in milliseconds between getting current time in a BerlinUhrShapeColorModel form
         */
        private const val DELAY = 1000L
    }
}