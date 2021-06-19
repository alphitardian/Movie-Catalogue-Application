package com.alphitardian.moviecatalogueapplication.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphitardian.moviecatalogueapplication.databinding.FragmentFavoriteMovieBinding
import com.alphitardian.moviecatalogueapplication.ui.movie.MovieAdapter
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private lateinit var fragmentMovieFavoriteBinding: FragmentFavoriteMovieBinding

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMovieFavoriteBinding =
            FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
            adapter = MovieAdapter()

            fragmentMovieFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(this, { movies ->
                fragmentMovieFavoriteBinding.progressBar.visibility = View.GONE
                adapter.submitList(movies)
                adapter.notifyDataSetChanged()
            })

            fragmentMovieFavoriteBinding.movieFavoriteRecyclerview.layoutManager =
                LinearLayoutManager(context)
            fragmentMovieFavoriteBinding.movieFavoriteRecyclerview.setHasFixedSize(true)
            fragmentMovieFavoriteBinding.movieFavoriteRecyclerview.adapter = adapter
        }
    }
}