package br.com.fiap.mentora.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DependencyInjection {
//    @Provides
//    @ViewModelScoped
//    fun provideSignUpViewModel(): SignUpViewModel = SignUpViewModel()
}