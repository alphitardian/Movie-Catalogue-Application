package com.alphitardian.moviecatalogueapplication.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlidngResource {
    private const val RESOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}