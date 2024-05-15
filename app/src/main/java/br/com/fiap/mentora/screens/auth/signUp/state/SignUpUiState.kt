package br.com.fiap.mentora.screens.auth.signUp.state

data class SignUpUiState(
    val fullName: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val aboutMe: String = "",
    val onNameChange: (String) -> Unit = {},
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val onPhoneChange: (String) -> Unit = {},
    val onAboutMeChange: (String) -> Unit = {},
) {
    fun canNavigateToAboutYou(): Boolean {
        return fullName.isNotBlank() && email.isNotBlank() && phone.isNotBlank() && password.isNotBlank()
    }

    fun canNavigateToYourHabilities(): Boolean {
        return aboutMe.isNotBlank()
    }
}