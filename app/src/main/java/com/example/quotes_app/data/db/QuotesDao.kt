package com.example.quotes_app.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.quotes_app.model.SavedQuotes
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(quote: SavedQuotes): Long

    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): Flow<List<SavedQuotes>>

    @Delete
    suspend fun deleteQuote(quote: SavedQuotes)
}