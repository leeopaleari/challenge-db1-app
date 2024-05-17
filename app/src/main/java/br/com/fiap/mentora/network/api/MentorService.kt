package br.com.fiap.mentora.network.api

import br.com.fiap.mentora.network.responses.MentorResponse
import br.com.fiap.mentora.network.responses.StudentResponse
import retrofit2.http.GET

interface MentorService {
    @GET("mentores")
    suspend fun getMentors(): MentorResponse
}