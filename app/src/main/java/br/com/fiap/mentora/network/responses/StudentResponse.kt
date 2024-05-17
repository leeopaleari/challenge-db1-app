package br.com.fiap.mentora.network.responses

import br.com.fiap.mentora.domain.user.User
import br.com.fiap.mentora.screens.app.search.state.SearchUiState

class StudentResponse(
    val usuarios: List<User>
) {
    fun toSearchScreenUiState() = SearchUiState(
        users = usuarios,
        isLoading = false,
        isError = false
    )
}

