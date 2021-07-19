plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
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
    api("androidx.lifecycle:lifecycle-extensions:2.2.0")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    api(Compose.activity)
    api(Compose.ui)
    api(Compose.uiGraphics)
    api(Compose.uiTooling)
    api(Compose.foundationLayout)
    api(Compose.material)
    api(Compose.runtimeLiveData)
    implementation(Compose.runtime)
    api(Compose.foundation)
    api(Compose.navigation)
    api(Compose.constraintLayout)
    api(Koin.core)
    api(Koin.android)


    implementation(Compose.activity)
    implementation(Android.coreKtx)
    implementation(Android.appCompat)
    implementation(Android.material)
    api(Accompanist.insets)


    api(project(":core"))

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}