package com.example.quotes_app.ui.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Delete
import com.example.quotes_app.model.Result
import com.example.quotes_app.model.SavedQuotes
import com.example.quotes_app.utils.getQuotesList
import com.example.quotes_app.utils.quotes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotesCard(quotes: Result, modifier: Modifier = Modifier, onSave: (Result) -> Unit) {
    Card(
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                CardTitleText(quotes.content, modifier = Modifier.weight(0.9f))
                IconButton(
                    onClick = {onSave(quotes)},
                ) {
                    Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Delete")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedQuotesCard(quotes: SavedQuotes, modifier: Modifier = Modifier, onDelete: (SavedQuotes) -> Unit) {
    Card(
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                CardTitleText(quotes.content, modifier = Modifier.weight(0.9f))
                IconButton(
                    onClick = {onDelete(quotes)},
                ) {
                    Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun CardTitleText(titleText: String, modifier: Modifier = Modifier) {
    Text(titleText, style = MaterialTheme.typography.labelMedium, modifier = modifier)
}

@Preview
@Composable
fun QuotesCardPreview() {
    QuotesCard(quotes =  Result(
        _id = "ghVnmSpeAo",
        author = "Thomas Edison",
        content = "Everything comes to him who hustles while he waits.",
        tags = listOf("Success", "Motivational"),
        authorSlug = "thomas-edison",
        length = 51,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ), modifier = Modifier,onSave={})
}

@Preview
@Composable
fun SavedQuotesCardPreview() {
    SavedQuotesCard(quotes =  SavedQuotes(
        id = 1,
        author = "Thomas Edison",
        content = "Everything comes to him who hustles while he waits.",
        tags = listOf("Success", "Motivational"),
        authorSlug = "thomas-edison",
        length = 51,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ), modifier = Modifier, onDelete = {})
}