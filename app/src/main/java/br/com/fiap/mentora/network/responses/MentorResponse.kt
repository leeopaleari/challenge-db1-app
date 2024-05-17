package br.com.fiap.mentora.network.responses

import br.com.fiap.mentora.domain.user.User
import br.com.fiap.mentora.screens.app.home.state.HomeUiState
import br.com.fiap.mentora.screens.app.search.state.SearchUiState

class MentorResponse(
    val mentores: List<User>
) {
    fun toHomeScreenUiState() = HomeUiState(
        users = mentores,
        isLoading = false,
        isError = false
    )
}

