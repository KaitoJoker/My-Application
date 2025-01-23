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
            try {
                // Panggil API dan ambil data film
                val response = MoviesNetwork.retrofit.getMovies()
                myResponseList.value = response.data // Pastikan `data` berisi `List<Movies>`
            } catch (e: Exception) {
                // Tangani kesalahan jaringan atau lainnya
                myResponseList.value = emptyList() // Berikan nilai kosong jika terjadi error
                e.printStackTrace()
            }
        }

    }
}