package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import javax.inject.Inject

/**
 * Implementation of [HoursMinutesSecondsToBerlinUhrShapeColorModelConverter]
 */
class HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl @Inject constructor(
    private val toBerlinUhrModelConverter: HoursMinutesSecondsToBerlinUhrModelConverter,
    private val toBerlinUhrShapeColorModelConverter: BerlinUhrModelToBerlinUhrShapeColorModelConverter,
) :
    HoursMinutesSecondsToBerlinUhrShapeColorModelConverter {

    override fun convert(from: HoursMinutesSecondsModel): BerlinUhrShapeColorModel {
        val berlinUhrModel = toBerlinUhrModelConverter.convert(from)
        return toBerlinUhrShapeColorModelConverter.convert(berlinUhrModel)
    }
}