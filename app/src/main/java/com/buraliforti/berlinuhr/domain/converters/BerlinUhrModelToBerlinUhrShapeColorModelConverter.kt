package com.buraliforti.berlinuhr.domain.converters

import com.buraliforti.berlinuhr.models.domain.BerlinUhrModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel

/**
 * Converter from [BerlinUhrModel] to [BerlinUhrShapeColorModel]
 * Basic model of lampsTurnedOn count is enriched with info about shape and color of each lamp
 */
interface BerlinUhrModelToBerlinUhrShapeColorModelConverter {

    /**
     * @param from Model of Berlin Uhr in the form of 5 rows of lights
     *
     * @return model of Berlin Uhr in the form of 5 rows of lamps different in shapes and colors
     */
    fun convert(from: BerlinUhrModel): BerlinUhrShapeColorModel
}