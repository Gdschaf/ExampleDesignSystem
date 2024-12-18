import com.github.gradle.node.npm.task.NpmTask

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.node.gradle)
}

android {
    namespace = "com.radhangs.mydesignsystem"
    compileSdk = 34

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
}

node {
    version = "22.12.0" // Node.js version, currently what I'm on
    npmVersion = "10.9.0" // npm version, again, currently what I'm on
    download = true // Downloads and installs Node.js and npm automatically if not available
}

// for install node_modules
tasks.register<NpmTask>("installDependencies") {
    args = listOf("install") // Equivalent to running "npm install"
}

tasks.named("preBuild") {
    dependsOn("installDependencies")
}

// for cleaning up node_modules
tasks.register<Delete>("cleanNodeModules") {
    delete(fileTree("MyDesignSystem") {
        include("**/node_modules")
    })
}

tasks.named("clean") {
    dependsOn("cleanNodeModules")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    //compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}