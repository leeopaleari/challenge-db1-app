package br.com.fiap.mentora.screens.app.search.state

import br.com.fiap.mentora.network.responses.User

data class SearchUiState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val showFilters: Boolean = false,
    val onToggleFilter: (Boolean) -> Unit = {}
) {
}