@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id(libs.plugins.kotlin.kapt.get().pluginId)//    id 'kotlin-kapt'
    id(libs.plugins.ksp.get().pluginId) version libs.versions.ksp.get()//    id 'com.google.dagger.hilt.android'
}

android {
    namespace = "com.core.database"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(":core-model"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    // room
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // di
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // coroutines
    implementation(libs.coroutines)

    // json parsing
    implementation(libs.moshi)
    kapt(libs.moshi.codegen )
}