package br.com.fiap.mentora.network.factory

import br.com.fiap.mentora.network.api.MentorService
import br.com.fiap.mentora.network.api.StudentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BASE_URL = "https://fiap-test-loop.free.beeceptor.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideStudentService(retrofit: Retrofit): StudentService = retrofit.create(StudentService::class.java)

    @Singleton
    @Provides
    fun provideMentorService(retrofit: Retrofit): MentorService = retrofit.create(MentorService::class.java)

}