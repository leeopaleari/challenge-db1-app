package br.com.fiap.mentora.screens.app.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.mentora.core.services.NotificationService
import br.com.fiap.mentora.domain.user.User
import br.com.fiap.mentora.network.api.MentorService
import br.com.fiap.mentora.network.api.StudentService
import br.com.fiap.mentora.screens.app.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val studentService: StudentService,
    private val mentorService: MentorService,
    private val notificationService: NotificationService
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            loadMentors()
        }
    }

    private suspend fun loadMentors() {
        _uiState.update {
            it.copy(
                isLoading = true, isError = false
            )
        }
        _uiState.update {
            try {
                mentorService.getMentors().toHomeScreenUiState()
            } catch (t: Throwable) {
                Log.e("HomeViewModel", "loadUsers: ", t)
                _uiState.value.copy(
                    isError = true, isLoading = false
                )
            }
        }
    }

    fun onLike(user: User) {
        _uiState.update { currentState ->
            val nextIndex = (currentState.indexToRender + 1) % currentState.users.size
            currentState.copy(indexToRender = nextIndex)
        }

        val currentUserSkills = listOf("Go", "Node.js", "Python")
        val commonSkills = user.skills.frontend.intersect(currentUserSkills) +
                user.skills.backend.intersect(currentUserSkills)
        Log.i("HomeViewModel", "onLike: $commonSkills")

        if (commonSkills.isNotEmpty()) {
            notificationService.sendNotification(
                title = "Deu Match!",
                message = "Conecte-se com ${user.name}"
            )
        }


//        val shouldSendNotification = Random.nextInt(100) < 30 // 30% de chance de dar match
//        if (shouldSendNotification) {
//            notificationService.sendNotification(
//                title = "Deu Match!",
//                message = "Conecte-se com ${user.name}"
//            )
//        }

    }

    fun onDislike(index: Int) {
        _uiState.update { currentState ->
            val nextIndex = if (index == currentState.users.size - 1) {
                0
            } else {
                currentState.indexToRender + 1
            }
            currentState.copy(indexToRender = nextIndex)
        }

        viewModelScope.launch {
            delay(150L)
            _uiState.update { currentState ->
                val updatedUsers = currentState.users.toMutableList().apply {
                    removeAt(index)
                }

                currentState.copy(
                    users = updatedUsers,
                    indexToRender = currentState.indexToRender.coerceAtMost(updatedUsers.size - 1)
                )
            }
        }
    }
}