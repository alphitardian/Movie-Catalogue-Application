package com.alphitardian.moviecatalogueapplication.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.ui.SplashActivity
import com.alphitardian.moviecatalogueapplication.utils.DataSource
import com.alphitardian.moviecatalogueapplication.utils.EspressoIdlidngResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = DataSource.getMovies()
    private val dummyTvShows = DataSource.getTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(SplashActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlidngResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlidngResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.movie_recyclerview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_recyclerview)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.tv_recyclerview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_recyclerview)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.movie_recyclerview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.movie_title_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_year_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_overview_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_image)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_card)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.tv_recyclerview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_recyclerview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.movie_title_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_rating_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_year_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_overview_textview)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_image)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_poster_card)).check(matches(isDisplayed()))
    }
}