package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel

/**
 * Converter from [HoursMinutesSecondsModel] to [BerlinUhrShapeColorModel]
 */
interface HoursMinutesSecondsToBerlinUhrShapeColorModelConverter {

    /**
     * @param from input in the form of [HoursMinutesSecondsModel]
     *
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    fun convert(from: HoursMinutesSecondsModel): BerlinUhrShapeColorModel
}