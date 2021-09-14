// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven(url = "https://kotlin.bintray.com/kotlinx/")

    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
        classpath(Firebase.classpathGoogleService)
        classpath(Firebase.classpathCrashlytics)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}