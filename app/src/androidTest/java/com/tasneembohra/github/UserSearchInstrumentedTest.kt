package com.tasneembohra.github

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.tasneembohra.github.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UserSearchInstrumentedTest {

    @get:Rule
    var activityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickSearchButton_Positive_LoadsUserInfo() {
        onView(withId(R.id.editText)).perform(typeText("tasneembohra"))

        onView(withId(R.id.btnSearch)).perform(click())

        onView(withId(R.id.tvUserName)).check(matches(withText("Tasneem")))
    }

    @Test
    fun clickSearchButton_Negative_LoadsUserInfo() {
        onView(withId(R.id.editText)).perform(typeText("tasneembo"))

        onView(withId(R.id.btnSearch)).perform(click())

        onView(withId(R.id.tvUserName)).check(matches(withText("")))
    }

    @Test
    fun scrollItemToFakePosition_ClickItem_CheckStarsCount() {
        onView(withId(R.id.editText)).perform(typeText("tasneembohra"))

        onView(withId(R.id.btnSearch)).perform(click())

        onView(withId(R.id.recyclerview))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))

        // Match the text in an item below the fold and check that it's displayed.
        onView(withId(R.id.tvStars)).check(matches(withText("0")))
    }

}