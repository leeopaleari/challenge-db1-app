package br.com.fiap.mentora.network.responses

import br.com.fiap.mentora.screens.app.search.state.SearchUiState

class UserResponse(
    val usuarios: List<User>
) {
    fun toSearchScreenUiState() = SearchUiState(
        users = usuarios,
        isLoading = false,
        isError = false
    )
}
data class User(
    val name: String = "",
    val email: String = "",
    val skills: Skills
)

data class Skills(
    val frontend: List<String> = emptyList(),
    val backend: List<String> = emptyList(),
)
