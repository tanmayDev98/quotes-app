package com.example.quotes_app.data.repository

import com.example.quotes_app.data.db.QuotesDao
import com.example.quotes_app.data.network.QuotesAPI
import com.example.quotes_app.model.QuotesListData
import com.example.quotes_app.model.SavedQuotes
import retrofit2.Response
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val quotesDao: QuotesDao,
    private val quotesAPI: QuotesAPI): IQuotesRepository {
    override suspend fun getQuotes(page: Int): Response<QuotesListData> {
        return quotesAPI.getQuotes(page)
    }

    override suspend fun upsert(quotes: SavedQuotes) = quotesDao.upsert(quotes)

    override fun getAllSavedQuotes() = quotesDao.getAllQuotes()

    override suspend fun deleteSavedQuotes(quotes: SavedQuotes) = quotesDao.deleteQuote(quotes)
}