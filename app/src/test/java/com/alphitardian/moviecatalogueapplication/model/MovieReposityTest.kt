package com.alphitardian.moviecatalogueapplication.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.alphitardian.moviecatalogueapplication.model.local.LocalDataSource
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.model.remote.RemoteDataSource
import com.alphitardian.moviecatalogueapplication.util.PagedListUtil
import com.alphitardian.moviecatalogueapplication.utils.AppExecutors
import com.alphitardian.moviecatalogueapplication.utils.DataSource
import com.alphitardian.moviecatalogueapplication.utils.LiveDataTestUtil
import com.alphitardian.moviecatalogueapplication.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieReposityTest {
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieReposity = FakeMovieReposity(remote, local, appExecutors)

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
        val dataSourceFactory =
            mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        movieReposity.getTopRatedMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataSource.getMovies()))

        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(
            movieResponses.size.toLong(),
            movieEntities.data?.size?.toLong()
        )
    }

    @Test
    fun getTopRatedTvShows() {
        val dataSourceFactory =
            mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        movieReposity.getTopRatedTvShows()

        val showEntites = Resource.success(PagedListUtil.mockPagedList(DataSource.getTvShows()))

        verify(local).getAllTvShow()
        assertNotNull(showEntites.data)
        assertEquals(
            showResponses.size.toLong(),
            showEntites.data?.size?.toLong()
        )
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<ShowEntity>()
        dummyEntity.value = DataSource.getMovies()[0]
        `when`(local.getMovieDetail(movieId)).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(movieReposity.getMovieDetail(movieId))

        verify(local).getMovieDetail(movieId)
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
    }

    @Test
    fun getTvShowDetail() {
        val dummyEntity = MutableLiveData<ShowEntity>()
        dummyEntity.value = DataSource.getTvShows()[0]
        `when`(local.getTvShowDetail(showId)).thenReturn(dummyEntity)

        val showEntities = LiveDataTestUtil.getValue(movieReposity.getTvShowDetail(showId))

        verify(local).getTvShowDetail(showId)
        assertNotNull(showEntities)
        assertNotNull(showEntities.title)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, ShowEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieReposity.getFavoriteMovie()

        val showEntites = Resource.success(PagedListUtil.mockPagedList(DataSource.getMovies()))

        verify(local).getFavoriteMovie()
        assertNotNull(showEntites)
        assertEquals(
            showResponses.size.toLong(),
            showEntites.data?.size?.toLong()
        )
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory =
            mock(androidx.paging.DataSource.Factory::class.java) as androidx.paging.DataSource.Factory<Int, ShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieReposity.getFavoriteTvShow()

        val showEntites = Resource.success(PagedListUtil.mockPagedList(DataSource.getTvShows()))

        verify(local).getFavoriteTvShow()
        assertNotNull(showEntites)
        assertEquals(
            showResponses.size.toLong(),
            showEntites.data?.size?.toLong()
        )
    }
}