package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import javax.inject.Inject

/**
 * Implementation of [HoursMinutesSecondsEntityToModelConverter]
 */
class HoursMinutesSecondsEntityToModelConverterImpl @Inject constructor() : HoursMinutesSecondsEntityToModelConverter {

    override fun convert(entity: HoursMinutesSecondsEntity): HoursMinutesSecondsModel {
        return HoursMinutesSecondsModel(
            hours = entity.hours,
            minutes = entity.minutes,
            seconds = entity.seconds
        )
    }
}