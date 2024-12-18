package ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import network.movies.Movies
import network.movies.MoviesNetwork

class MoviesViewModel: ViewModel() {
    val myResponseList: MutableLiveData<List<Movies>> = MutableLiveData()
    fun getMovies() {
        viewModelScope.launch {
            myResponseList.value  = MoviesNetwork.retrofit.getMovies().data
        }
    }

}