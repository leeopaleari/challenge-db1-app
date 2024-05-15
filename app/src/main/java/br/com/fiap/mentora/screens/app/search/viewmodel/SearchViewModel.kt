package br.com.fiap.mentora.screens.app.search.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.mentora.network.api.UsersService
import br.com.fiap.mentora.screens.app.search.state.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject() constructor(
    private val usersService: UsersService
) : ViewModel() {
    private val TAG = "SearchViewModel"

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            loadUsers()
            _uiState.update { currentState ->
                currentState.copy(
                    onToggleFilter = { showFilter ->
                        _uiState.value = _uiState.value.copy(showFilters = showFilter)
                    }
                )

            }
        }
    }

    private suspend fun loadUsers() {
        try {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    isError = false
                )
            }
            _uiState.update {
                usersService.getUsers().toSearchScreenUiState()
            }
            Log.i(TAG, "loadUsers: ${uiState.value}")
        } catch (t: Throwable) {
            Log.e(TAG, "loadUsers: ")
        }

    }
}