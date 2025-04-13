package com.example.quotes_app.data.repository

import com.example.quotes_app.model.QuotesListData
import com.example.quotes_app.model.SavedQuotes
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface IQuotesRepository {
    suspend fun getQuotes(page: Int): Response<QuotesListData>
    suspend fun upsert(quotes: SavedQuotes): Long
    fun getAllSavedQuotes(): Flow<List<SavedQuotes>>
    suspend fun deleteSavedQuotes(quotes: SavedQuotes)
}