plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("net.objecthunter:exp4j:0.4.8")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
// - - ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
// - - LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
// - - Retrofit2
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // ExoPlayer
    //implementation ("com.google.android.exoplayer:exoplayer-core:2.18.2")  // Main ExoPlayer dependency
//    implementation ("com.google.android.exoplayer:exoplayer-hls:2.18.2")   // If you're using HLS streams
//    implementation ("com.google.android.exoplayer:extension-youtube:2.18.2") // Add-on YouTube
//    implementation ("com.google.android.exoplayer:exoplayer-ui:2.18.1")    // Untuk UI
//    implementation ("com.google.android.exoplayer:exoplayer-dash:2.18.1")
//    implementation ("com.google.android.exoplayer:exoplayer:2.18.2")
    // Android Youtube API
    implementation ("com.arthenica:mobile-ffmpeg-full:4.4")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}