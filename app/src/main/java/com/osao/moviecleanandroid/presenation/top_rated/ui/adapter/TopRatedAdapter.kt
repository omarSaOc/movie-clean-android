package com.osao.moviecleanandroid.presenation.top_rated.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osao.moviecleanandroid.R
import com.osao.moviecleanandroid.databinding.ItemTopRatedBinding
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedMovieUI
import com.osao.moviecleanandroid.utils.basicDiffUtil
import com.osao.moviecleanandroid.utils.inflate
import com.osao.moviecleanandroid.utils.loadUrl

class TopRatedAdapter(
    private val listener: (TopRatedMovieUI) -> Unit
) : RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>(
) {

    var list: List<TopRatedMovieUI> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view = parent.inflate(R.layout.item_top_rated,  false)
        return TopRatedViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    inner class TopRatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemTopRatedBinding.bind(itemView)

        fun bind(movie: TopRatedMovieUI) = with(binding) {
            tvTitleTopRatedMovie.text = movie.title
            ivTopRatedMovie.loadUrl("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
        }
    }


}