package br.com.fiap.mentora.network.api

import br.com.fiap.mentora.network.responses.UserResponse
import retrofit2.http.GET

interface UsersService {
    @GET("users")
    suspend fun getUsers(): UserResponse
}