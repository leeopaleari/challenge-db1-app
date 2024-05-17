package br.com.fiap.mentora.domain.user

data class User(
    val name: String = "",
    val email: String = "",
    val skills: Skills,
    val aboutYou: String = ""
)

data class Skills(
    val frontend: List<String> = emptyList(),
    val backend: List<String> = emptyList(),
)
