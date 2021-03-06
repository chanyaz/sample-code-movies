package io.petros.movies.presentation.feature.splash.navigator

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.petros.movies.presentation.feature.movies.navigator.MoviesLauncher
import org.junit.Before
import org.junit.Test

class SplashActivityNavigatorTest {

    private lateinit var testedClass: SplashActivityNavigator
    private val moviesLauncherMock = mock<MoviesLauncher>()

    @Before
    fun setUp() {
        testedClass = SplashActivityNavigator(moviesLauncherMock)
    }

    @Test
    fun `When navigating from splash activity, then movies activity launches`() {
        testedClass.navigate()

        verify(moviesLauncherMock).launch()
    }

    @Test
    fun `When navigating from splash activity, then splash activity finishes`() {
        testedClass.navigate()

        verify(moviesLauncherMock).finish()
    }

}
