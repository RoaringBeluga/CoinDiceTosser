package com.example.kotlintutorial2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @Test
    fun testButton() {
        ActivityScenario.launch(
            MainActivity::class.java
        )
        onView(withId(R.id.btn_roll))
            .check(matches(withText(R.string.btn_roll)))
            .perform(click())
    }

    @Test
    fun testSwitch() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.switch_is_coin))
            .check(matches(isNotChecked()))
            .perform(click())
            .check(matches(isChecked()))
        onView(withId(R.id.btn_roll))
            .check(matches(withText("TOSS")))
    }
}