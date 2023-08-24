pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "duriant"
include(":app")
include(":core-common")
include(":core-data")
include(":core-designSystem")
include(":core-localstorage")
include(":core-model")
include(":core-navigation")
include(":core-network")
include(":core-theme")
