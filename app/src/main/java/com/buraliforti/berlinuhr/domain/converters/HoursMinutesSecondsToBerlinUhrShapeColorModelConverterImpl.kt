package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import javax.inject.Inject

/**
 * Implementation of [HoursMinutesSecondsToBerlinUhrShapeColorModelConverter]
 */
class HoursMinutesSecondsToBerlinUhrShapeColorModelConverterImpl @Inject constructor() :
    HoursMinutesSecondsToBerlinUhrShapeColorModelConverter {

    override fun convert(from: HoursMinutesSecondsModel): BerlinUhrShapeColorModel {
        return BerlinUhrShapeColorModel(
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList(),
            emptyList()
        )
    }
}