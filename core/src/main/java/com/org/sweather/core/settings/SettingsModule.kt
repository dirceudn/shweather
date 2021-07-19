package com.org.sweather.core.settings

import com.org.sweather.core.settings.data.repository.SettingsRepositoryImpl
import com.org.sweather.core.settings.domain.SettingsRepository
import com.org.sweather.core.settings.domain.usecase.GetMetricsUseCase
import com.org.sweather.core.settings.domain.usecase.SaveMetricsUseCase
import com.org.sweather.core.settings.domain.usecase.getMetricsUseCase
import com.org.sweather.core.settings.domain.usecase.saveMetricsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module


@ExperimentalCoroutinesApi
val settingsRepositoryModule = module {
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}

val settingsUseCase = module {
    factory<SaveMetricsUseCase> { saveMetricsUseCase(get()) }
    factory<GetMetricsUseCase> { getMetricsUseCase(get()) }
}

@ExperimentalCoroutinesApi
fun settingsModule() = settingsRepositoryModule + settingsUseCase
