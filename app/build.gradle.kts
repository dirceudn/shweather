plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = AndroidSdk.appId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.compile)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions("full")

    productFlavors {
        create("dev") {

        }
        create("prod") {

        }
    }
    compileOptions {

        // Flag to enable support for the new language APIs
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {

    implementation(Compose.runtime)
    implementation(LifeCycle.runtimeKtx)
    implementation(Logs.napier)

    implementation(Koin.core)
    implementation(Koin.android)
    //android core
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.runner)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(Test.composeTest)

    //project
    api(project(":presentation"))
    api(project(":core"))
}