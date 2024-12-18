package network.movies

data class ResponseMovies(
    val sucsess: Boolean,
    val data: List<Movies>
)
