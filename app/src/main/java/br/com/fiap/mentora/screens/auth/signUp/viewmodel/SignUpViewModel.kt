package br.com.fiap.mentora.screens.auth.signUp.viewmodel

import androidx.compose.ui.text.capitalize
import androidx.lifecycle.ViewModel
import br.com.fiap.mentora.screens.auth.signUp.state.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onPasswordChange = { password ->
                    _uiState.value = _uiState.value.copy(password = password)
                },
                onEmailChange = { email ->
                    _uiState.value = _uiState.value.copy(email = email)
                },
                onNameChange = { fullName ->
                    _uiState.value = _uiState.value.copy(fullName = capitalizeName(fullName))
                },
                onPhoneChange = { phone ->
                    _uiState.update { it.copy(phone = phone) }
                },
                onAboutMeChange = { aboutMe ->
                    _uiState.update { it.copy(aboutMe = aboutMe) }
                }
            )
        }
    }
}

private fun capitalizeName(fullName: String): String {
    return fullName.split(" ").joinToString(separator = " ") { word ->
        word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}