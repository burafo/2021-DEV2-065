package com.buraliforti.berlinuhr.models.domain


/**
 * Model of Berlin Uhr in the form of 5 rows of lights
 * Lights are turned on one by one one from left to right
 * Lamp that is turned on cannot have lamp that is turned off on left side of it
 *
 * @param secondsRowLightsOnCount from 0 to 1
 * @param multiHoursLightOnCount from 0 to 4
 * @param HoursLightOnCount from 0 to 4
 * @param HoursLightOnCount from 0 to 11
 * @param HoursLightOnCount from 0 to 4
 */
data class BerlinUhrModel(
    val secondsRowLightsOnCount: Int,
    val multiHoursLightOnCount: Int,
    val HoursLightOnCount: Int,
    val multiMinutesLightOnCount: Int,
    val minutesLightOnCount: Int,
)