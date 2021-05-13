package com.alphitardian.moviecatalogueapplication.ui.movie

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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieReposity: MovieReposity

    @Mock
    private lateinit var observer : Observer<List<ShowEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieReposity)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataSource.getMovies()
        val movies = MutableLiveData<List<ShowEntity>>()
        movies.value = dummyMovies

        `when`(movieReposity.getTopRatedMovies()).thenReturn(movies)

        val movieEntities = viewModel.getMovies().value

        verify(movieReposity).getTopRatedMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}