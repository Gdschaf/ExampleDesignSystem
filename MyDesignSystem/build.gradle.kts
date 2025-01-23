import com.github.gradle.node.npm.task.NpmTask

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    // alias(libs.plugins.node.gradle)
}

android {
    namespace = "com.radhangs.mydesignsystem"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

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
    kotlin {
        explicitApi()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}


// node {
//     version = "18.17.1" // latest available through this I believe
//     npmVersion = "9.6.7" // works with the node version above
//     download = true // Downloads and installs Node.js and npm automatically if not available
// }
//
// // for install node_modules
// tasks.register<NpmTask>("installDependencies") {
//     args = listOf("install") // Equivalent to running "npm install"
// }
//
// tasks.named("preBuild") {
//     dependsOn("installDependencies")
// }
//
// // for cleaning up node_modules
// tasks.register<Delete>("cleanNodeModules") {
//     delete(fileTree("MyDesignSystem") {
//         include("**/node_modules")
//     })
// }
//
// tasks.named("clean") {
//     dependsOn("cleanNodeModules")
// }

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    //compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.runtime)
    implementation(libs.compose.material3)
    implementation(libs.compose.google.fonts)
    implementation(libs.compose.ui.tooling)
    implementation(libs.coil.compose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    debugImplementation(libs.compose.ui.tooling)
}