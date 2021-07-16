dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Sweather"
include(":app")
include(":core")
include(":presentation")
include(":presentation:ui")
include(":presentation:home")
