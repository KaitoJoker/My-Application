package network.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

internal class MovieAdapter(
    private val context: Context,
    private var movieList:  List<Movies>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var judul: TextView = view.findViewById(R.id.judul)
        var rating: TextView = view.findViewById(R.id.rating)
        var deskripsi: WebView = view.findViewById(R.id.deskripsi)
        var sutradara: TextView = view.findViewById(R.id.sutradara)
        var foto : ImageView= view.findViewById(R.id.foto)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.judul.text = movie.judul
        // Menyiapkan URL YouTube IFrame API
        val youtubeUrl = "https://www.youtube.com/embed/" + movie.deskripsi  // movie.deskripsi berisi video ID

        // Mengaktifkan JavaScript pada WebView
        val webSettings = holder.deskripsi.settings
        webSettings.javaScriptEnabled = true

        // Memuat URL YouTube ke dalam WebView
        holder.deskripsi.loadUrl(youtubeUrl)
        holder.rating.text = movie.rating
        holder.sutradara.text = movie.sutradara
        val urlImage = "http://192.168.125.250:4000/" + movie.foto
        Picasso
            .get()
            .load(urlImage)
            .resize(650, 850)
            .centerCrop()
            .into(holder.foto)
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
}