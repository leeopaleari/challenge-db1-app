package br.com.fiap.mentora.domain.user

data class User(
    val fullName: String,
    val email: String,
    val phone: String,
    val password: String,
    val aboutMe: String,
    val skills: List<String>,
    val skillLevels: Map<String, String>,
    val preferredTime: String
)