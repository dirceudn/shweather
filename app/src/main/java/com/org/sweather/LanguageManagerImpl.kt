package com.org.sweather

import android.app.Application
import android.os.Build
import com.org.sweather.core.LanguageManager

class LanguageManagerImpl(private  val sweatherApplication: Application) : LanguageManager {
    override fun getLanguage(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sweatherApplication.resources.configuration.locales[0].language
        } else
            sweatherApplication.resources.configuration.locale.language
    }
}

