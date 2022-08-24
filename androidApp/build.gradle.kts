plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.android.fakestoreapp.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha07"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Compose.activity)
    implementation(Compose.compiler)
    implementation(Compose.material)
    implementation(Compose.navigation)
    implementation(Compose.runtime)
    implementation(Compose.constraintLayout)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)

    implementation(SplashScreen.splashScreen)
    implementation(Shimmer.shimmer)
    implementation(Accompanist.systemUIController)

    implementation(Koin.koinAndroid)

    implementation(Coil.coil)

    implementation(ComposeDestination.composeDestination)
    implementation(ComposeDestination.core)
    implementation(ComposeDestination.composeDestination)
}