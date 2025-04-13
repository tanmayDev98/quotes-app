package com.example.quotes_app.ui

import com.example.quotes_app.QuotesApplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.quotes_app.ui.theme.QuotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val modifier = Modifier
//        val appContainer = (application as QuotesApplication).container
        setContent {
            QuotesAppTheme {
                QuotesApp(modifier = modifier.fillMaxSize())
            }
        }
    }
}