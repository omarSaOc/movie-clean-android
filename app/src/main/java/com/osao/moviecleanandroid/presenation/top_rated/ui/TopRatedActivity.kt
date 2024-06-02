package com.osao.moviecleanandroid.presenation.top_rated.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.osao.moviecleanandroid.R
import com.osao.moviecleanandroid.databinding.ActivityTopRatedBinding
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI
import com.osao.moviecleanandroid.presenation.top_rated.ui.adapter.TopRatedAdapter
import com.osao.moviecleanandroid.presenation.top_rated.viewmodel.TopRatedViewModel
import com.osao.moviecleanandroid.utils.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedActivity : BaseActivity() {


    private val binding by lazy {
        ActivityTopRatedBinding.inflate(layoutInflater)
    }

    private val viewModel: TopRatedViewModel by viewModels()
    private lateinit var topRatedAdapter: TopRatedAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        listener()
        fetchTopRatedMovies()
        observer()
    }

    private fun initView() = with(binding) {
        rvTopRatedMovies.layoutManager = GridLayoutManager(this@TopRatedActivity, 3)
        topRatedAdapter = TopRatedAdapter {
            Toast.makeText(this@TopRatedActivity, "Movie clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun listener() = with(binding) {
        fab.setOnClickListener {
//            val intent = Intent(this@TopRatedActivity, UpcomingActivity::class.java)
//            startActivity(intent)
        }

        swipeRefreshLayout.setOnRefreshListener {
            fetchTopRatedMovies()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchTopRatedMovies() {
        showLoading()
        viewModel.getTopRatedMovies()
    }

    private fun observer() {
        viewModel.topRatedMovies.observe(this, ::getTopRatedMovies)
    }

    private fun getTopRatedMovies(value: TopRatedResponseUI) {
        dismissLoading()
        topRatedAdapter.list = value.results
        binding.rvTopRatedMovies.adapter = topRatedAdapter
    }
}