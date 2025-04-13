package com.example.quotes_app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotes_app.model.QuotesListData
import com.example.quotes_app.model.Result
import com.example.quotes_app.model.SavedQuotes

fun LazyListScope.quotes(
    quotesList: QuotesListData,
    onSave: (Result) -> Unit
) {
    items(quotesList.results) {quote -> QuotesCard(
        quote, modifier = Modifier.padding(horizontal = 8.dp),
        onSave = onSave
    ) }
}

fun LazyListScope.savedQuotes(
    quotesList: List<SavedQuotes>,
    onDelete: (SavedQuotes) -> Unit
) {
    items(quotesList) {quote -> SavedQuotesCard(quote, modifier = Modifier.padding(horizontal = 8.dp),
        onDelete = onDelete
    ) }
}