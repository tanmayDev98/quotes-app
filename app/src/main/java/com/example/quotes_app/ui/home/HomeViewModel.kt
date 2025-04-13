package com.example.quotes_app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quotes_app.data.repository.QuotesRepository
import com.example.quotes_app.model.QuotesListData
import com.example.quotes_app.model.Result
import com.example.quotes_app.model.SavedQuotes
import com.example.quotes_app.utils.ErrorMessage
import com.example.quotes_app.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.UUID
import javax.inject.Inject

sealed interface HomeUiState {
    val isLoading: Boolean
    val errorMessages: List<ErrorMessage>

    data class NoQuotes(
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>,
    ) : HomeUiState

    data class HasQuotes(
        val quotes: QuotesListData,
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>
    ): HomeUiState
}

private data class HomeViewModelState(
    val quotes: QuotesListData? = null,
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList()
) {
    fun toUiState(): HomeUiState =
        if(quotes == null) {
            HomeUiState.NoQuotes(
                isLoading = isLoading,
                errorMessages = errorMessages,
            )
        } else {
            HomeUiState.HasQuotes(
                quotes = quotes,
                isLoading = isLoading,
                errorMessages = errorMessages
            )
        }
}

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class HomeViewModel @Inject constructor(private val quotesRepository: QuotesRepository): ViewModel() {
    private val viewModelState = MutableStateFlow(
        HomeViewModelState(
            isLoading = true,
        )
    )

    val uiState = viewModelState
        .map(HomeViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            val response = quotesRepository.getQuotes(1)
            val result = handleQuotesResponse(response)
            viewModelState.update {
                when(result) {
                    is NetworkResult.Success -> {
                        it.copy(quotes = result.data, isLoading = false)
                    }
                    is NetworkResult.Error -> {
                        val errorMessages = it.errorMessages + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            messageId = result.message ?: "Unknown Error"
                        )
                        it.copy(errorMessages = errorMessages, isLoading = false)
                    }
                    is NetworkResult.Loading -> {it.copy(isLoading = false)}
                }
            }
        }
    }

    private fun handleQuotesResponse(response: Response<QuotesListData>): NetworkResult<QuotesListData> {
        if(response.isSuccessful) {
            response.body()?.let { result ->
                return NetworkResult.Success(result)
            }
        }
        return  NetworkResult.Error(response.message())
    }

    fun saveQuote(quotes: Result) = viewModelScope.launch {
        val savedQuote = SavedQuotes(
            author = quotes.author,
            authorSlug = quotes.authorSlug,
            content = quotes.content,
            dateAdded = quotes.dateAdded,
            dateModified = quotes.dateModified,
            length = quotes.length,
            tags = quotes.tags,
        )
        quotesRepository.upsert(savedQuote)
    }

//    companion object {
//        fun provideFactory(
//            quotesRepository: QuotesRepository
//        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return HomeViewModel(quotesRepository) as T
//            }
//        }
//    }
}