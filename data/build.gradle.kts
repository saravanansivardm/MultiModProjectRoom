@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.com.android.devtool.ksp)
    kotlin("kapt")
}

android {
    namespace = "com.example.multimoduleapplication.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(platform(libs.activity.compose.bom))
    implementation(libs.activity.compose.ui)
    implementation(libs.activity.compose.ui.graphics)
    implementation(libs.activity.compose.material3)


    implementation(libs.androidx.hilt.compose.navigation)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.room)
    ksp(libs.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation (libs.room.ktx)

}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
