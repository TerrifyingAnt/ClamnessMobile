plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "ant.realitresonance.clamness"
    compileSdk = 34

    defaultConfig {
        applicationId = "ant.realitresonance.clamness"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val room_version = "2.6.1"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // coil
    implementation("io.coil-kt:coil-compose:1.3.1")

    // retorfit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")

    // di
    implementation("com.google.dagger:hilt-android:2.51")
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("androidx.hilt:hilt-common:1.2.0")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    annotationProcessor("com.google.dagger:hilt-android:2.51")
    implementation("androidx.hilt:hilt-work:1.2.0")

    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.2.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // dataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")


    // extended icons
    implementation("org.jetbrains.compose.material:material-icons-extended:1.6.1")

    // navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")


    // cool shimmering effect
    implementation("com.valentinilk.shimmer:compose-shimmer:1.3.0")


    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")

    // logging interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // JsonProperties
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")

    // image picker
    implementation ("io.github.huhx:compose-image-picker:1.0.8")

    implementation ("io.mockk:mockk:1.9.3")
    // https://mvnrepository.com/artifact/org.mockito.kotlin/mockito-kotlin
    implementation("org.mockito.kotlin:mockito-kotlin:5.3.1")

    // графики
    implementation ("com.patrykandpatrick.vico:compose:1.12.0")
    implementation ("com.patrykandpatrick.vico:compose-m3:1.12.0")
    implementation ("com.patrykandpatrick.vico:core:1.12.0")
}

kapt {
    correctErrorTypes = true
}