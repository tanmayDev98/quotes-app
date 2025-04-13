package com.example.quotes_app

import android.app.Application
import android.content.Context
import com.example.quotes_app.data.db.QuotesDao
import com.example.quotes_app.data.db.QuotesDatabase
import com.example.quotes_app.data.network.QuotesAPI
import com.example.quotes_app.data.repository.IQuotesRepository
import com.example.quotes_app.data.repository.QuotesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//interface AppContainer {
//    val quotesRepository : QuotesRepository
//}
//
//class AppContainerImpl(private val applicationContext: Context) : AppContainer {
//    private val quotesDatabase: QuotesDatabase by lazy {
//        QuotesDatabase.invoke(applicationContext)
//    }
//
//    override val quotesRepository: QuotesRepository by lazy {
//        QuotesRepository(quotesDatabase)
//    }
//}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuotesDatabase(appContext: Application): QuotesDatabase {
        return QuotesDatabase.invoke(appContext)
    }

    @Provides
    fun provideQuotesDao(database: QuotesDatabase): QuotesDao {
        return database.getQuotesDao()
    }
}