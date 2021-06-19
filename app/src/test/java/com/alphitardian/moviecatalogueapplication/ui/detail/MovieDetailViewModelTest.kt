package com.alphitardian.moviecatalogueapplication.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.utils.DataSource
import com.alphitardian.moviecatalogueapplication.vo.Resource
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
class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val dummyMovie = DataSource.getMovies()[0]
    private val showId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieReposity: MovieReposity

    @Mock
    private lateinit var observer: Observer<ShowEntity>

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel(movieReposity)
        viewModel.setSelectedShow(showId)
        viewModel.getIsMovie(dummyMovie.isMovie)
    }

    @Test
    fun setSelectedShow() {
    }

    @Test
    fun getShow() {
        val dummyMovie = DataSource.getMovies().get(0)
        val movie = MutableLiveData<ShowEntity>()
        movie.value = dummyMovie

        `when`(movieReposity.getMovieDetail(showId)).thenReturn(movie as LiveData<ShowEntity>)

        viewModel.setSelectedShow(showId)

        viewModel.movieResource.observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}
