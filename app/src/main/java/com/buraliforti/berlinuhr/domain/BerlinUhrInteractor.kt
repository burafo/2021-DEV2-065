package com.buraliforti.berlinuhr.domain

import androidx.annotation.WorkerThread
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel

/**
 * Interactor that is responsible for getting time data from system (device)
 * and preparing [BerlinUhrShapeColorModel] for presentation layer
 */
@WorkerThread
interface BerlinUhrInteractor {

    /**
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    fun getBerlinUhrShapeColorModel(): BerlinUhrShapeColorModel
}