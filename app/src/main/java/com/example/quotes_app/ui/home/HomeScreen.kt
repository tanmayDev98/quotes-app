package com.example.quotes_app.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.quotes_app.model.Result
import com.example.quotes_app.model.SavedQuotes
import com.example.quotes_app.ui.components.quotes

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val scrollState = rememberLazyListState()
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    QuotesList(modifier, scrollState, uiState, onSave = { quote -> homeViewModel.saveQuote(quote) })
}

@Composable
fun QuotesList(modifier: Modifier,
               scrollState: LazyListState,
               uiState: HomeUiState,
               onSave: (Result) -> Unit) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = scrollState)
        {
            when (val state = uiState) {
                is HomeUiState.NoQuotes -> {

                }
                is HomeUiState.HasQuotes -> {
                    quotes(state.quotes, onSave = onSave)
                }
            }
        }
    }
}