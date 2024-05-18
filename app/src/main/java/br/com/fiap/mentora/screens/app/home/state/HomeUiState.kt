package br.com.fiap.mentora.screens.app.home.state

import br.com.fiap.mentora.domain.user.User

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val users: List<User> = emptyList(),
    val indexToRender: Int = 0
) {

}