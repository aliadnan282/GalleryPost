package com.example.systemtask.gallery.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.systemtask.R
import com.example.systemtask.gallery.activity.GalleryActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailFragmentTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(GalleryActivity::class.java)

    fun initDetailFragment() {
        val fragment = launchFragmentInContainer<DetailFragment>()
    }

    //@Test
    fun is_image_visible() {
        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}