package br.com.fiap.mentora.network.api

import br.com.fiap.mentora.network.responses.StudentResponse
import retrofit2.http.GET

interface StudentService {
    @GET("users")
    suspend fun getUsers(): StudentResponse
}