package br.com.fiap.mentora.screens.auth.signUp.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fiap.mentora.screens.auth.signUp.state.SignUpUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
                    _uiState.value = _uiState.value.copy(fullName = fullName)
                },
                onPhoneChange = { phone ->
                    _uiState.update { it.copy(phone = phone) }
                },
                onAboutMeChange = { phone ->
                    _uiState.update { it.copy(phone = phone) }
                }
            )
        }
    }
}
