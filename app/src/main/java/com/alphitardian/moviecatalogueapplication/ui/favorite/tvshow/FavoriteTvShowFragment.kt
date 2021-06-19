package com.alphitardian.moviecatalogueapplication.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphitardian.moviecatalogueapplication.databinding.FragmentFavoriteTvShowBinding
import com.alphitardian.moviecatalogueapplication.ui.movie.MovieAdapter
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding

    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentFavoriteTvShowBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]
            adapter = MovieAdapter()

            fragmentFavoriteTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteTvShow().observe(this, { tvShows ->
                fragmentFavoriteTvShowBinding.progressBar.visibility = View.GONE
                adapter.submitList(tvShows)
                adapter.notifyDataSetChanged()
            })

            fragmentFavoriteTvShowBinding.tvFavoriteRecyclerview.layoutManager =
                LinearLayoutManager(context)
            fragmentFavoriteTvShowBinding.tvFavoriteRecyclerview.setHasFixedSize(true)
            fragmentFavoriteTvShowBinding.tvFavoriteRecyclerview.adapter = adapter
        }
    }
}