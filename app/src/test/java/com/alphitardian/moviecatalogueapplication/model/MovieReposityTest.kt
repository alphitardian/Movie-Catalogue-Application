package com.alphitardian.moviecatalogueapplication.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.utils.DataSource
import com.alphitardian.moviecatalogueapplication.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieReposityTest {
    private val remote = mock(RemoteDataSource::class.java)
    private val movieReposity = FakeMovieReposity(remote)

    private val movieResponses = DataSource.getMoviesRemote()
    private val movie = movieResponses.get(0)
    private val movieId = movieResponses.get(0).id.toString()
    private val showResponses = DataSource.getTvShowsRemote()
    private val show = showResponses.get(0)
    private val showId = showResponses.get(0).id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getTopRatedMovies() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(movieResponses)
        }.`when`(remote).getTopRatedMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieReposity.getTopRatedMovies())

        verify(remote).getTopRatedMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieReposity.getTopRatedMovies().value?.size?.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getTopRatedTvShows() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllShowReceived(showResponses)
        }.`when`(remote).getTopRatedTvShows(any())

        val showEntites = LiveDataTestUtil.getValue(movieReposity.getTopRatedTvShows())

        verify(remote).getTopRatedTvShows(any())
        assertNotNull(showEntites)
        assertEquals(movieReposity.getTopRatedTvShows().value?.size?.toLong(), showEntites.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(movie)
        }.`when`(remote).getMovieDetail(any(), eq(movieId))

        val movieEntities = LiveDataTestUtil.getValue(movieReposity.getMovieDetail(movieId))

        verify(remote).getMovieDetail(any(), eq(movieId))
        assertNotNull(movieEntities)
        assertEquals(movieId, movieEntities.id)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(show)
        }.`when`(remote).getTvShowDetail(any(), eq(showId))

        val showEntities = LiveDataTestUtil.getValue(movieReposity.getTvShowDetail(showId))

        verify(remote).getTvShowDetail(any(), eq(showId))
        assertNotNull(showEntities)
        assertEquals(showId, showEntities.id)
    }
}