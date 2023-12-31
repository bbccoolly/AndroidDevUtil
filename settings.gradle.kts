pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://repository.jboss.org/maven2")
//        maven(url = "https://maven.aliyun.com/repository/central")
//        maven(url = "https://maven.aliyun.com/repository/public")
//        maven(url = "https://maven.aliyun.com/repository/google")
//        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://repository.jboss.org/maven2")
//        maven(url = "https://maven.aliyun.com/repository/central")
//        maven(url = "https://maven.aliyun.com/repository/public")
//        maven(url = "https://maven.aliyun.com/repository/google")
//        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
    }
}

rootProject.name = "AndroidDevUtil"
include(":app")
include(":core-preferences")
include(":core-model")
include(":core-network")
include(":core-database")
include(":core-data")
include(":core-uploadservice")
