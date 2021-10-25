package com.buraliforti.berlinuhr.domain

import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrShapeColorModelConverter
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import javax.inject.Inject

/**
 * Implementation of [TimeToBerlinUhrScreenInteractor]
 */
class TimeToBerlinUhrScreenInteractorImpl @Inject constructor(
    private val converter: HoursMinutesSecondsToBerlinUhrShapeColorModelConverter,
) : TimeToBerlinUhrScreenInteractor {

    /**
     * @param input model of time consisting of hours, minutes and seconds
     *
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    override fun getBerlinUhrShapeColorModelFromInputTime(input: HoursMinutesSecondsModel): BerlinUhrShapeColorModel {
        return converter.convert(input)
    }
}