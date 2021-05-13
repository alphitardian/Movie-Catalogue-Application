package com.alphitardian.moviecatalogueapplication.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alphitardian.moviecatalogueapplication.databinding.FragmentTvShowBinding
import com.alphitardian.moviecatalogueapplication.ui.movie.MovieAdapter
import com.alphitardian.moviecatalogueapplication.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]
            val showAdapter = MovieAdapter()

            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getShows().observe(this, {
                fragmentTvShowBinding.progressBar.visibility = View.GONE
                showAdapter.setMovies(it)
                showAdapter.notifyDataSetChanged()
            })

            with(fragmentTvShowBinding.tvRecyclerview) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showAdapter
            }
        }
    }
}