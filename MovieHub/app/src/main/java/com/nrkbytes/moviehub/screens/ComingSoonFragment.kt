package com.nrkbytes.moviehub.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import com.nrkbytes.moviehub.screens.upcoming.UpcomingScreen

class ComingSoonFragment : BottomNavFragment() {
    lateinit var rootView: ComposeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        rootView = ComposeView(requireContext())
        return rootView
    }

    override fun onFirstDisplay() {
        rootView.setContent {
            MaterialTheme(colors = darkColors(background = Color.Black)) {
                UpcomingScreen()
            }
        }
    }
}