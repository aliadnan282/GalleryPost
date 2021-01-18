package com.example.systemtask.gallery.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.systemtask.R
import com.example.systemtask.gallery.activity.GalleryActivity
import com.example.systemtask.gallery.activity.MainActivity
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GalleryFragmentTest{
    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(GalleryActivity::class.java)

    fun launch_fragment(){
        val fragment= launchFragmentInContainer<GalleryFragment>()
    }

    @Test
    fun is_progressbar_visible(){
        Espresso.onView(ViewMatchers.withId(R.id.pb_loading))
            .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))
    }

    @Test
    fun is_recyclerview_visible(){
        Espresso.onView(ViewMatchers.withId(R.id.rv_gallery))
            .check(ViewAssertions.matches((ViewMatchers.isDisplayed())))
    }
}