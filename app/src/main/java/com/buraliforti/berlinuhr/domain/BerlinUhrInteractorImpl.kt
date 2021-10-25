package com.buraliforti.berlinuhr.domain

import androidx.annotation.WorkerThread
import com.buraliforti.berlinuhr.domain.converters.BerlinUhrModelToBerlinUhrShapeColorModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsEntityToModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrModelConverter
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import javax.inject.Inject

/**
 * Implementation of [BerlinUhrInteractor]
 *
 * @param timeRepository provider of current time entity from one of available sources
 * @param toHoursMinutesSecondsModelConverter converter of HoursMinutesSecondsEntity to HoursMinutesSecondsModel
 * @param toBerlinUhrModelConverter converter from HoursMinutesSecondsModel to BerlinUhrModel
 * @param toBerlinUhrShapeColorModelConverter converter from BerlinUhrModel to BerlinUhrShapeColorModel
 */
@WorkerThread
class BerlinUhrInteractorImpl @Inject constructor(
    private val timeRepository: TimeRepository,
    private val toHoursMinutesSecondsModelConverter: HoursMinutesSecondsEntityToModelConverter,
    private val toBerlinUhrModelConverter: HoursMinutesSecondsToBerlinUhrModelConverter,
    private val toBerlinUhrShapeColorModelConverter: BerlinUhrModelToBerlinUhrShapeColorModelConverter,
) : BerlinUhrInteractor {

    override fun getBerlinUhrShapeColorModel(): BerlinUhrShapeColorModel {
        val entity = timeRepository.getCurrentTime()
        val hoursMinutesSecondsModel = toHoursMinutesSecondsModelConverter.convert(entity)
        val berlinUhrModel = toBerlinUhrModelConverter.convert(hoursMinutesSecondsModel)
        return toBerlinUhrShapeColorModelConverter.convert(berlinUhrModel)
    }
}