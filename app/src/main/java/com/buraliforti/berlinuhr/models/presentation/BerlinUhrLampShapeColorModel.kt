package com.buraliforti.berlinuhr.models.presentation

import androidx.annotation.ColorRes

/**
 * Model of a single lamp of Berlin Uhr
 *
 * @param color a color resource reference (e.g. android.R.color.black).
 * @param shape shape of a lamp (e.g. rectangle)
 * @param isLampOn state of a lamp, true - is turned on, otherwise - false
 */
data class BerlinUhrLampShapeColorModel(
    @ColorRes
    val color: Int,
    val shape: BerlinUhrLampShape?,
    val isLampOn: Boolean,
)