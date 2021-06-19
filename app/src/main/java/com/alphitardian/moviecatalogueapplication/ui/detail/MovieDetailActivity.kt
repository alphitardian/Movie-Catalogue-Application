package com.alphitardian.moviecatalogueapplication.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.databinding.ActivityMovieDetailBinding
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SHOW = "extra_show"
        const val EXTRA_MOVIE_CHECK = "extra_movie_check"
    }

    private lateinit var movieDetailBinding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)

        supportActionBar?.hide()

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

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
                    setFavoriteState(it.isFavorite)
                })


            }
        }

        movieDetailBinding.addFavoriteButton.setOnClickListener {
            viewModel.setFavorite()

            viewModel.getShow().observe(this, {
                val state = it.isFavorite
                setFavoriteState(state)
            })
        }
    }

    private fun loadMovieDetail(show: ShowEntity) {
        val rating = show.userRating.toDouble() * 10

        movieDetailBinding.apply {
            movieTitleTextview.text = show.title
            movieYearTextview.text = show.releaseYear
            movieRatingTextview.text = getString(R.string.moviedetail_userrating, rating.toInt())
            movieOverviewTextview.text = show.overview

            Glide.with(this@MovieDetailActivity)
                .load("https://image.tmdb.org/t/p/w500${show.imagePath}")
                .into(moviePosterImage)
            Glide.with(this@MovieDetailActivity)
                .load("https://image.tmdb.org/t/p/w500${show.imagePath}")
                .into(moviePosterCard)
        }
    }

    private fun setFavoriteState(state: Boolean) {
        val icon = movieDetailBinding.addFavoriteButton

        if (state) {
            icon.setCompoundDrawablesWithIntrinsicBounds(
                getDrawable(R.drawable.ic_favorite_fill_black),
                null,
                null,
                null
            )
        } else {
            icon.setCompoundDrawablesWithIntrinsicBounds(
                getDrawable(R.drawable.ic_favorite_outline),
                null,
                null,
                null
            )
        }
    }

}