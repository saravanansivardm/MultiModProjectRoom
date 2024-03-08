@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.com.android.devtool.ksp)
    kotlin("kapt")
}
android {
    namespace = "com.example.multimoduleapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.multimoduleapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.theme)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.activity.compose.bom))
    implementation(libs.activity.compose.ui)
    implementation(libs.activity.compose.ui.graphics)
    implementation(libs.activity.compose.ui.tooling.preview)
    implementation(libs.activity.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.activity.compose.bom))
    androidTestImplementation(libs.activity.compose.ui.test.junit4)
    debugImplementation(libs.activity.compose.ui.test.manifest)

    implementation(libs.androidx.hilt.compose.navigation)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
