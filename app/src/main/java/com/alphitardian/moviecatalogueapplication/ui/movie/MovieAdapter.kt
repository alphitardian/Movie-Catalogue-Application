package com.alphitardian.moviecatalogueapplication.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alphitardian.moviecatalogueapplication.databinding.ItemsMovieBinding
import com.alphitardian.moviecatalogueapplication.model.local.entity.ShowEntity
import com.alphitardian.moviecatalogueapplication.ui.detail.MovieDetailActivity
import com.bumptech.glide.Glide

class MovieAdapter internal constructor() :
    PagedListAdapter<ShowEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: ShowEntity) {
            with(binding) {
                movieTitleTextview.text = movie.title
                movieYearTextview.text = movie.releaseYear
                movieOverviewTextview.text = movie.overview
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${movie.imagePath}")
                    .into(moviePosterImage)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_SHOW, movie.id)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_CHECK, movie.isMovie)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}