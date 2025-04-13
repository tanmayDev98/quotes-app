package com.example.quotes_app.ui.saved

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
import com.example.quotes_app.model.SavedQuotes
import com.example.quotes_app.ui.components.savedQuotes

@Composable
fun SavedScreen(modifier: Modifier, savedViewModel: SavedViewModel = hiltViewModel()) {
    val scrollState = rememberLazyListState()
    val uiState by savedViewModel.uiState.collectAsStateWithLifecycle()
    SavedQuotesList(modifier, scrollState, uiState, onDelete = { quote -> savedViewModel.deleteQuote(quote) })
}

@Composable
fun SavedQuotesList(modifier: Modifier,
               scrollState: LazyListState,
               uiState: SavedUiState,
               onDelete: (SavedQuotes) -> Unit) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = scrollState)
        {
            when (uiState) {
                is SavedUiState.NoQuotes -> {

                }
                is SavedUiState.HasQuotes -> {
                   savedQuotes(uiState.quotes, onDelete = onDelete)
                }
            }
        }
    }
}