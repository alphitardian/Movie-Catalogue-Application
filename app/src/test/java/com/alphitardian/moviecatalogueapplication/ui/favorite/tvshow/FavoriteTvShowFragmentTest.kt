package com.alphitardian.moviecatalogueapplication.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.alphitardian.moviecatalogueapplication.model.MovieReposity
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.ui.favorite.movie.FavoriteMovieViewModel
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowFragmentTest {
    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieReposity: MovieReposity

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowViewModel(movieReposity)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyMovie = pagedList
        Mockito.`when`(dummyMovie.size).thenReturn(10)

        val movie = MutableLiveData<PagedList<ShowEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(movieReposity.getFavoriteTvShow()).thenReturn(movie)

        val movieEntities = viewModel.getFavoriteTvShow().value

        verify(movieReposity).getFavoriteTvShow()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}