package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.data.HoursMinutesSecondsEntity
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel

/**
 * Converter of [HoursMinutesSecondsEntity] to [HoursMinutesSecondsModel]
 */
interface HoursMinutesSecondsEntityToModelConverter {

    /**
     * @param entity of time consisting of hours, minutes and seconds
     *
     * @return model of time consisting of hours, minutes and seconds
     */
    fun convert(entity: HoursMinutesSecondsEntity): HoursMinutesSecondsModel
}