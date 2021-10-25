package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel

/**
 * Converter from [HoursMinutesSecondsModel] to [BerlinUhrModel]
 */
interface HoursMinutesSecondsToBerlinUhrModelConverter {

    /**
     * @param from model of time consisting of hours, minutes and seconds
     *
     * @return model of Berlin Uhr in the form of 5 rows of lights
     */
    fun convert(from: HoursMinutesSecondsModel): BerlinUhrModel
}