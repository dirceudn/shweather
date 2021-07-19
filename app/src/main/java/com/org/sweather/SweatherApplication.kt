package com.org.sweather

import android.app.Application
import com.org.sweather.app.di.appModule
import com.org.sweather.core.app.di.initKoin
import com.org.sweather.presentation.BuildConfig
import com.org.sweather.search.di.searchModule
import com.org.sweather.settings.di.settingsModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger


class SweatherApplication : Application() {

    @InternalCoroutinesApi
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            // Debug build

            // init napier
            Napier.base(DebugAntilog("Sweather"))
        }

        val deviceLanguageGetter = LanguageManagerImpl(this)
        val preferenceGetter = ModelPreferencesManager(this)

        initKoin(
            BuildConfig.WEATHER_BASE_URL,
            BuildConfig.CITIES_BASE_URL,
            BuildConfig.DEBUG,
            BuildConfig.WEATHER_ID,
            deviceLanguageGetter,
            preferenceGetter,
            listOf(appModule, searchModule, settingsModule)
        ) {
            androidLogger()
            androidContext(this@SweatherApplication)
        }

    }
}

