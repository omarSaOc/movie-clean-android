package com.osao.moviecleanandroid.presenation.top_rated.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osao.moviecleanandroid.domain.top_rated.models.TopRatedResponseUI
import com.osao.moviecleanandroid.domain.top_rated.use_cases.TopRatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TopRatedViewModel @Inject constructor(
    private val topRatedUseCase: TopRatedUseCase
): ViewModel() {

    private var _topRatedMovies = MutableLiveData<TopRatedResponseUI>()
    val topRatedMovies : LiveData<TopRatedResponseUI> get() = _topRatedMovies

    fun getTopRatedMovies() {
        viewModelScope.launch {
            _topRatedMovies.value = topRatedUseCase.invoke()
        }
    }
}