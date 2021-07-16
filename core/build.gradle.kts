import Koin.android

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}")

    // Ktor
    implementation(Ktor.core)
    implementation(Ktor.json)
    implementation(Ktor.serialisation)
    implementation(Ktor.clientLogging)
    implementation(Ktor.androidClient)


    // Serialize
    api(Koin.core)
    api(Koin.android)
    // Serialize
    implementation(KotlinXSerialisation.serialisation)
    implementation(KotlinXSerialisation.json)


    // date time
    implementation(DateTime.dateTime)

    // Logs
    api(Logs.napier)

}