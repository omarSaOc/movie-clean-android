package com.osao.moviecleanandroid.presenation.popular.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.osao.moviecleanandroid.databinding.ActivityPopularBinding
import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI
import com.osao.moviecleanandroid.presenation.popular.ui.adapter.PopularAdapter
import com.osao.moviecleanandroid.presenation.popular.viewmodel.PopularViewModel
import com.osao.moviecleanandroid.presenation.top_rated.ui.TopRatedActivity
import com.osao.moviecleanandroid.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularActivity : BaseActivity() {

    private val binding by lazy {
        ActivityPopularBinding.inflate(layoutInflater)
    }

    private val viewModel: PopularViewModel by viewModels()
    private lateinit var popularAdapter: PopularAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        listener()
        fetchPopularMovies()
        observer()
    }

    private fun initView() = with(binding) {
        rvPopularMovies.layoutManager = GridLayoutManager(this@PopularActivity, 3)
        popularAdapter = PopularAdapter {
            Toast.makeText(this@PopularActivity, "Movie clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun listener() = with(binding) {
        fab.setOnClickListener {
            val intent = Intent(this@PopularActivity, TopRatedActivity::class.java)
            startActivity(intent)
        }

        swipeRefreshLayout.setOnRefreshListener {
            fetchPopularMovies()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchPopularMovies() {
        showLoading()
        viewModel.getPopularMovies()
    }

    private fun observer() {
        viewModel.popularMovies.observe(this, ::getPopularMovies)
    }

    private fun getPopularMovies(value: PopularResponseUI) {
        dismissLoading()
        popularAdapter.list = value.results
        binding.rvPopularMovies.adapter = popularAdapter
    }
}