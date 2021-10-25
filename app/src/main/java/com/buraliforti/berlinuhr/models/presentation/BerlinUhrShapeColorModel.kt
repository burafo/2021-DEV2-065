package com.buraliforti.berlinuhr.models.presentation

/**
 * Model of Berlin Uhr in the form of
 * 5 rows of lamps different in shapes and colors
 *
 * @param secondsRowLamps row of seconds lamps
 * @param multiHoursRowLamps row of multiple hours lamps
 * @param hoursRowLamps row of single hours lamps
 * @param multiMinutesRowLamps row of multiple minutes lamps
 * @param minutesRowLamps row of single minutes lamps
 */
data class BerlinUhrShapeColorModel(
    val secondsRowLamps: List<BerlinUhrLampShapeColorModel>,
    val multiHoursRowLamps: List<BerlinUhrLampShapeColorModel>,
    val hoursRowLamps: List<BerlinUhrLampShapeColorModel>,
    val multiMinutesRowLamps: List<BerlinUhrLampShapeColorModel>,
    val minutesRowLamps: List<BerlinUhrLampShapeColorModel>,
)