package com.buraliforti.berlinuhr

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.buraliforti.berlinuhr.presentation.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class BerlinUhrScreenViewsInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.buraliforti.berlinuhr", appContext.packageName)
    }

    @Test
    fun viewsMustBeVisible() {
        // Start up
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.RESUMED)

        // Verify BerlinUhr Screen with all lamps is displayed on screen
        onView(withId(R.id.berlin_uhr_screen)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.seconds_lamp)).check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.multi_hours_lamp_1)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_hours_lamp_2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_hours_lamp_3)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_hours_lamp_4)).check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.hours_lamp_1)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.hours_lamp_2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.hours_lamp_3)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.hours_lamp_4)).check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.multi_minutes_lamp_1)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_3)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_4)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_5)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_6)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_7)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_8)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_9)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_10)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.multi_minutes_lamp_11)).check(ViewAssertions.matches(isDisplayed()))

        onView(withId(R.id.minutes_lamp_1)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.minutes_lamp_2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.minutes_lamp_3)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.minutes_lamp_4)).check(ViewAssertions.matches(isDisplayed()))
    }
}
