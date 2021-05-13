package com.alphitardian.moviecatalogueapplication.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alphitardian.moviecatalogueapplication.databinding.ActivityMovieDetailBinding
import com.alphitardian.moviecatalogueapplication.model.ShowEntity
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SHOW = "extra_show"
        const val EXTRA_MOVIE_CHECK = "extra_movie_check"
    }

    private lateinit var movieDetailBinding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)

        supportActionBar?.hide()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

        movieDetailBinding.progressBar.visibility = View.VISIBLE
        movieDetailBinding.content.visibility = View.GONE
        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getString(EXTRA_SHOW)
            if (showId != null) {
                viewModel.setSelectedShow(showId)
                viewModel.getIsMovie(intent.getBooleanExtra(EXTRA_MOVIE_CHECK, true))

                viewModel.getShow().observe(this, {
                    movieDetailBinding.progressBar.visibility = View.GONE
                    movieDetailBinding.content.visibility = View.VISIBLE
                    loadMovieDetail(it)
                })


            }
        }
    }

    private fun loadMovieDetail(show: ShowEntity) {
        var rating = show.userRating.toDouble() * 10

        movieDetailBinding.movieTitleTextview.text = show.title
        movieDetailBinding.movieYearTextview.text = show.releaseYear
        movieDetailBinding.movieRatingTextview.text = "User Rating : ${rating}%"
        movieDetailBinding.movieOverviewTextview.text = show.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${show.imagePath}")
            .into(movieDetailBinding.moviePosterImage)
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${show.imagePath}")
            .into(movieDetailBinding.moviePosterCard)
    }
}