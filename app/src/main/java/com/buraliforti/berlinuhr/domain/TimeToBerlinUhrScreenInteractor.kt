package com.buraliforti.berlinuhr.domain

import androidx.annotation.WorkerThread
import com.buraliforti.berlinuhr.models.domain.HoursMinutesSecondsModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel

/**
 * Interactor that is responsible for getting time data from user input
 * and preparing [BerlinUhrShapeColorModel] for presentation layer
 */
@WorkerThread
interface TimeToBerlinUhrScreenInteractor {

    /**
     * @param input user input in the form of [HoursMinutesSecondsModel]
     *
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    fun getBerlinUhrShapeColorModelFromInputTime(input: HoursMinutesSecondsModel): BerlinUhrShapeColorModel
}