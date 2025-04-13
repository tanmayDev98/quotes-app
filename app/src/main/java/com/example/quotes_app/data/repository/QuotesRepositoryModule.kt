package com.example.quotes_app.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class QuotesRepositoryModule {

    @Binds
    abstract fun providesQuotesRepository(repository: QuotesRepository): IQuotesRepository
}