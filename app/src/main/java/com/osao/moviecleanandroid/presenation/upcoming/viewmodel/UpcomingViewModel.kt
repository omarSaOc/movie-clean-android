package com.osao.moviecleanandroid.presenation.upcoming.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osao.moviecleanandroid.domain.upcoming.models.UpcomingMovieResponseUI
import com.osao.moviecleanandroid.domain.upcoming.use_cases.UpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val upcomingUseCase: UpcomingUseCase
): ViewModel() {
    private var _upcomingMovies = MutableLiveData<UpcomingMovieResponseUI>()
    val upcomingMovies : LiveData<UpcomingMovieResponseUI> get() = _upcomingMovies

    fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovies.value = upcomingUseCase.invoke()
        }

    }
}