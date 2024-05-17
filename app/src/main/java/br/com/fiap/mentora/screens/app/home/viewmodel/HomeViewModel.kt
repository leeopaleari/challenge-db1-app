package br.com.fiap.mentora.screens.app.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.mentora.network.api.MentorService
import br.com.fiap.mentora.network.api.StudentService
import br.com.fiap.mentora.screens.app.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val studentService: StudentService, private val mentorService: MentorService
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {

            loadMentors()
        }
    }

    private suspend fun loadMentors() {
        _uiState.update {
            it.copy(
                isLoading = true, isError = false
            )
        }
        _uiState.update {
            try {
                mentorService.getMentors().toHomeScreenUiState()
            } catch (t: Throwable) {
                Log.e("HomeViewModel", "loadUsers: ", t)
                _uiState.value.copy(
                    isError = true, isLoading = false
                )
            }
        }
    }
}