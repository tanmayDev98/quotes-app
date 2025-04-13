package com.example.quotes_app.ui.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes_app.data.repository.QuotesRepository
import com.example.quotes_app.model.SavedQuotes
import com.example.quotes_app.utils.ErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface SavedUiState {
    val errorMessages:  List<ErrorMessage>
    val isLoading: Boolean

    data class NoQuotes(
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>,
    ) : SavedUiState

    data class HasQuotes(
        val quotes: List<SavedQuotes>,
        override val errorMessages: List<ErrorMessage>,
        override val isLoading: Boolean): SavedUiState
}

private data class SavedViewModelState(
    val quotes: List<SavedQuotes>? = null,
    val isLoading: Boolean,
    val errorMessages: List<ErrorMessage> = emptyList()
)
{
    fun toUiState(): SavedUiState =
        if(quotes == null) {
            SavedUiState.NoQuotes(
                isLoading = isLoading,
                errorMessages = errorMessages,
            )
        } else {
            SavedUiState.HasQuotes(
                quotes = quotes,
                isLoading = isLoading,
                errorMessages = errorMessages
            )
        }
}

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class SavedViewModel @Inject constructor(private val quotesRepository: QuotesRepository): ViewModel() {
    private val viewModelState = MutableStateFlow(
        SavedViewModelState(isLoading = true)
    )

    private val quotesFlow = quotesRepository.getAllSavedQuotes().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    val uiState = quotesFlow.map { quotes ->
        SavedViewModelState(isLoading = false, quotes = quotes)
            .toUiState()
    } .stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        initialValue = SavedUiState.NoQuotes(true, emptyList())
    )

    fun deleteQuote(Quote: SavedQuotes) {
        viewModelScope.launch {
            val delete = quotesRepository.deleteSavedQuotes(Quote)
        }
    }

//    companion object {
//        fun providesFactory(quotesRepository: QuotesRepository)
//        :ViewModelProvider.Factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return SavedViewModel(quotesRepository) as T
//            }
//        }
//    }
}