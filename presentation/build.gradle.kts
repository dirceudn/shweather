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
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    flavorDimensions("full")

    productFlavors {
        create("dev") {
            buildConfigField("String", "WEATHER_BASE_URL", "\"api.openweathermap.org\"")
            buildConfigField("String", "WEATHER_ID", "\"6bb2fc202cc8e921172d7e138b04484a\"")

        }
        create("prod") {
            buildConfigField("String", "WEATHER_ID", "\"6bb2fc202cc8e921172d7e138b04484a\"")
            buildConfigField("String", "WEATHER_BASE_URL", "\"api.openweathermap.org\"")
        }
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

    api(project(":core"))
    api(project(":presentation:ui"))
    api(project(":presentation:home"))
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}