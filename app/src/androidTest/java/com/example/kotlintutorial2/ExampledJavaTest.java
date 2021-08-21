package com.example.kotlintutorial2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anyOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampledJavaTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void tosserOffTest() {
        //getActivity()
        onView(withId(R.id.switch_is_coin))
                .check(matches(isNotChecked()))
                .perform(click())
                .check(matches(isChecked()));
    }

    @Test
    public void tossTheDice() {
        for(int i = 0; i < 10; i++) {
            onView(withId(R.id.switch_is_coin))
                    .check(matches(isNotChecked()));
            onView(withId(R.id.btn_roll))
                    .check(matches(isDisplayed()))
                    .check(matches(withText("ROLL")))
                    .perform(click());
            onView(withId(R.id.coinDicePic))
                    .check(matches(anyOf(
                            withContentDescription("1"),
                            withContentDescription("2"),
                            withContentDescription("3"),
                            withContentDescription("4"),
                            withContentDescription("5"),
                            withContentDescription("6")
                    )));
        }
    }

    @Test
    public void tossTheCoin() {
        onView(withId(R.id.switch_is_coin))
                .check(matches(isNotChecked()))
                .perform(click())
                .check((matches(isChecked())));
        onView(withId(R.id.btn_roll))
                .check(matches(isDisplayed()))
                .check(matches(withText("TOSS")))
                .perform(click());
        onView(withId(R.id.coinDicePic))
                .check(matches(anyOf(
                        withContentDescription("Heads"),
                        withContentDescription("Tails")
                )));
    }
}
