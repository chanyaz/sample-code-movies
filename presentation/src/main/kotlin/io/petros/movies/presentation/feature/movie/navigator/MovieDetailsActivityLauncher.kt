package io.petros.movies.presentation.feature.movie.navigator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import io.petros.movies.R
import io.petros.movies.domain.model.movie.Movie
import io.petros.movies.presentation.feature.movie.MovieDetailsActivity
import io.petros.movies.presentation.feature.movies.view.SharedElementMovie
import io.petros.movies.presentation.getExtraName

class MovieDetailsActivityLauncher constructor(
    private val activity: AppCompatActivity
) : MovieDetailsLauncher {

    companion object {

        private val EXTRA_CLASS = MovieDetailsActivity::class.java
        private val EXTRA_MOVIE = getExtraName(EXTRA_CLASS, "movie")

        @Suppress("UnsafeCast")
        @SuppressLint("SyntheticAccessor")
        fun getMovie(intent: Intent) = intent.getSerializableExtra(EXTRA_MOVIE) as Movie

    }

    override fun launch(movie: Movie) {
        activity.startActivity(getIntent(movie))
    }

    override fun launch(movie: SharedElementMovie) {
        activity.startActivity(getIntent(movie.movie), getSharedElement(movie))
    }

    private fun getIntent(movie: Movie): Intent {
        return Intent(activity, EXTRA_CLASS).also {
            it.putExtra(EXTRA_MOVIE, movie)
        }
    }

    private fun getSharedElement(movie: SharedElementMovie): Bundle? {
        val sharedElement = activity.getString(R.string.movie_backdrop_shared_element)
        val anim = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, movie.sharedElement, sharedElement)
        return anim.toBundle()
    }

    override fun finish() {
        activity.finish()
    }

}
