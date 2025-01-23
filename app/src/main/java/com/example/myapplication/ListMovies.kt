package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import network.movies.MovieAdapter
import network.movies.Movies
import ui.screens.MoviesViewModel

class ListMovies : AppCompatActivity() {
    private val TAG = "ListMovies :"
    private val MovieList = ArrayList<Movies>()
    private lateinit var movieAdapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
        val recyclerView: RecyclerView = findViewById(R.id.recycleView)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        val topAppBar: MaterialToolbar = findViewById(R.id.topAppBar)
        topAppBar.inflateMenu(R.menu.top_app_bar)

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    // Handle favorite icon press
                    true
                }
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        // Observasi LiveData dari ViewModel
        viewModel.myResponseList.observe(this, Observer { movies ->
            if (!movies.isNullOrEmpty()) {
                movieAdapter = MovieAdapter(this, movies)
                recyclerView.adapter = movieAdapter
            } else {
                // Tangani jika data kosong
                println("Data kosong atau terjadi error.")
            }

            for (movies in movies) {
                Log.d(TAG, movies.id.toString())
                Log.d(TAG, movies.judul)
                Log.d(TAG, movies.deskripsi)
                Log.d(TAG, movies.rating)
                Log.d(TAG, movies.foto)

            }
        })
        //movieAdapter.notifyDataSetChanged()
        viewModel.getMovies()
    }

}