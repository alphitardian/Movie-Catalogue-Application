package com.alphitardian.moviecatalogueapplication.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alphitardian.moviecatalogueapplication.databinding.ItemsMovieBinding
import com.alphitardian.moviecatalogueapplication.model.ShowEntity
import com.alphitardian.moviecatalogueapplication.ui.detail.MovieDetailActivity
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<ShowEntity>()

    fun setMovies(movie: List<ShowEntity>?) {
        if (movie == null) return

        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie : ShowEntity) {
            with(binding) {
                movieTitleTextview.text = movie.title
                movieYearTextview.text = movie.releaseYear
                movieOverviewTextview.text = movie.overview
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${movie.imagePath}").into(moviePosterImage)

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