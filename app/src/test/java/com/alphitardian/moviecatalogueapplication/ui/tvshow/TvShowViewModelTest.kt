package com.alphitardian.moviecatalogueapplication.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.ShowEntity
import com.alphitardian.moviecatalogueapplication.utils.DataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieReposity: MovieReposity

    @Mock
    private lateinit var observer: Observer<List<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieReposity)
    }

    @Test
    fun getShows() {
        val dummyShows = DataSource.getTvShows()
        val shows = MutableLiveData<List<ShowEntity>>()
        shows.value = dummyShows

        `when`(movieReposity.getTopRatedTvShows()).thenReturn(shows)

        val tvShowEntities = viewModel.getShows().value

        verify(movieReposity).getTopRatedTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}