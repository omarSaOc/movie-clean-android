package com.osao.moviecleanandroid.presenation.popular.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osao.moviecleanandroid.domain.popular.models.PopularResponseUI
import com.osao.moviecleanandroid.domain.popular.use_cases.PopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    private val popularUseCase: PopularUseCase
): ViewModel() {

    private var _popularMovies = MutableLiveData<PopularResponseUI>()
    val popularMovies : LiveData<PopularResponseUI> get() = _popularMovies

    fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = popularUseCase.invoke()
        }
    }
}