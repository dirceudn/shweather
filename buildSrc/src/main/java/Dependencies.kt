object Versions {

    //- Android native libs
    const val compose = "1.0.0-beta09"
    const val composeActivity = "1.3.0-rc01"
    const val navigation = "2.4.0-alpha04"
    const val gradle = "7.0.0-beta05"
    const val constraintLayoutCompose = "1.0.0-alpha07"
    const val composeRouterVersion = "0.18.0"
    const val accompanist = "0.14.0"
    const val lifecycleVersion = "2.2.0"
    const val appCompat = "1.3.0"
    const val kotlin = "1.4.32"
    const val sharedPreferences = ""
    const val androidKtx = "1.6.0"
    const val constraintLayout = "2.0.4"
    const val material = "1.4.0"
    const val firebaseBom = "26.1.0"


    //tests
    const val junit = "4.13"
    const val testRunner = "1.3.0"
    //-kotlin jetbrains libs

    // network
    const val ktor = "1.6.1"
    const val kotlinx = "1.2.2"
    //courotines

    const val kotlinCoroutines = "1.4.3"
    //---

    //- 3rd party lib
    const val koin = "3.0.2"
    const val kotlinxDateTime = "0.2.1"
    const val timber = "4.7.1"
    const val napier = "1.5.0"
    const val jsoup = "1.13.1"


}

object Accompanist {
    const val accomPanist = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"

}

object Logs {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"
}


object Firebase {
    const val bom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val classpathGoogleService = "com.google.gms:google-services:4.3.8"
    const val classpathCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.5.2"
    const val classpathPerf = "com.google.firebase:perf-plugin:1.3.3"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val perf = "com.google.firebase:firebase-perf-ktx"
    const val config = "com.google.firebase:firebase-config-ktx"
    const val cloudStore = "com.google.firebase:firebase-firestore-ktx"
    const val auth = "com.google.firebase:firebase-auth-ktx"
}


object Material {
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Kotlin {
    const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"

}

object Compose {
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}"
}

object AndroidSdk {
    const val appId = "com.org.sweather"
    const val min = 21
    const val compile = 30
    const val target = compile
    const val versionName = "1.0"
    const val versionCode = 1
    const val buildToolsVersion = "30.0.3"
}

object Android {
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object KotlinXSerialisation {
    const val serialisation =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinx}"
    const val protobuf =
        "org.jetbrains.kotlinx:kotlinx-serialization-protobuf:${Versions.kotlinx}"
    const val json =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx}"
}


object LifeCycle {
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val livedataExt = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifeCycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"
    const val viewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

}

object Gson {
    const val gson = "com.google.code.gson:gson:2.8.7"
}

object DateTime {
    const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
}

object Test {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.testRunner}"
    const val composeTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}}"
}

object Jsoup {
    const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"
}


object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
}

object Ktor {
    const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val json = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val serialisation = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val androidClient = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val iosClient = "io.ktor:ktor-client-ios:${Versions.ktor}"
    const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
}