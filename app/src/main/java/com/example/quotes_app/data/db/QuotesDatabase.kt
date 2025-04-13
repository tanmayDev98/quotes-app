package com.example.quotes_app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.quotes_app.model.SavedQuotes

@Database(entities = [SavedQuotes::class], version = 1)
@TypeConverters(Converters::class)
abstract class QuotesDatabase: RoomDatabase() {
    abstract fun getQuotesDao(): QuotesDao

    companion object {
        @Volatile
        private var instance: QuotesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): QuotesDatabase = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuotesDatabase::class.java,
                "quotes_db.db"
            ).build()
    }
}