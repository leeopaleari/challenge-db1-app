package br.com.fiap.mentora

import android.app.Application
import br.com.fiap.mentora.core.services.NotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        NotificationService(this)
    }
}