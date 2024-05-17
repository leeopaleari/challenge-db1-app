package br.com.fiap.mentora.screens.app.search.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.mentora.domain.user.User
import br.com.fiap.mentora.network.api.StudentService
import br.com.fiap.mentora.screens.app.search.state.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject() constructor(
    private val studentService: StudentService
) : ViewModel() {
    private val TAG = "SearchViewModel"

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    private val _selectedSkills = MutableStateFlow<List<String>>(emptyList())
    val selectedSkills = _selectedSkills.asStateFlow()

    private val _filteredUsers = MutableStateFlow<List<User>>(emptyList())
    val filteredUsers = _filteredUsers.asStateFlow()

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

    fun onSelectSkill(skill: String) {
        val currentSkills = _selectedSkills.value.toMutableList()

        if (currentSkills.contains(skill)) {
            currentSkills.remove(skill)
        } else {
            currentSkills.add(skill)
        }

        _selectedSkills.update { currentSkills }
        filterUsers()

    }

    private fun filterUsers() {
        val skills = _selectedSkills.value

        _filteredUsers.value = if (skills.isEmpty()) {
            _uiState.value.users
        } else {
            _uiState.value.users.filter { user ->
                (user.skills.frontend.any { skill ->
                    skills.any { it.equals(skill, ignoreCase = true) }
                } || user.skills.backend.any { skill ->
                    skills.any { it.equals(skill, ignoreCase = true) }
                })
            }
        }
    }

    private suspend fun loadUsers() {
        _uiState.update {
            it.copy(
                isLoading = true,
                isError = false
            )
        }
        _uiState.update {
            try {
                studentService.getUsers().toSearchScreenUiState()
            } catch (t: Throwable) {
                Log.e(TAG, "loadUsers: ", t)
                _uiState.value.copy(
                    isError = true,
                    isLoading = false
                )
            }
        }
        filterUsers()
    }
}