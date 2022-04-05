plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

fun getVersionInt(name: String) = parent!!.ext.get(name) as Int
fun getVersionString(name: String) = parent!!.ext.get(name) as String
fun String.toFormattedString() = "\"${this}\""
val composeVersion = getVersionString("composeVersion")

android {
    compileSdk = getVersionInt("compileSdkVersion")

    defaultConfig {
        minSdk = getVersionInt("minSdkVersion")
        targetSdk = getVersionInt("targetSdkVersion")
        buildConfigField(
            "String",
            "VERSION_NAME",
            "1.0".toFormattedString()
        )
        buildConfigField("int", "VERSION_CODE", "1")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    sourceSets {
        getByName("debug") {
            java.srcDir("src/common/java")
        }
        getByName("release") {
            java.srcDir("src/common/java")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val accompanistVersion = "0.23.1"
    val activityComposeVersion = "1.4.0"
    val coilComposeVersion = "1.4.0"
    val lifecycleVersion = getVersionString("lifecycleVersion")
    val koinVersion = getVersionString("koinVersion")
    val navigationComposeVersion = "2.4.0"
    val okhttpVersion = getVersionString("okhttpVersion")
    val retrofitVersion = getVersionString("retrofitVersion")
    val mockkVersion = "1.12.2"
    val leakCanaryVersion = "2.8.1"

    val coreTestingVersion = "2.1.0"
    val coroutinesVersion = "1.6.0"
    val testCoreVersion = "1.4.0"
    val robolectricVersion = "4.7.3"

    implementation("androidx.core:core-ktx:${getVersionString("ktxVersion")}")
    implementation("androidx.appcompat:appcompat:${getVersionString("appCompatVersion")}")
    implementation("com.google.android.material:material:${getVersionString("materialVersion")}")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-insets:$accompanistVersion")
    implementation("io.coil-kt:coil-compose:$coilComposeVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:$okhttpVersion"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion")

    testImplementation("com.squareup.okhttp3:mockwebserver")
    testImplementation("junit:junit:${getVersionString("junitVersion")}")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("androidx.arch.core:core-testing:$coreTestingVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    testImplementation("org.robolectric:robolectric:$robolectricVersion")
    testImplementation("io.insert-koin:koin-test:$koinVersion")
    testImplementation("io.insert-koin:koin-test-junit:$koinVersion")

    androidTestImplementation("androidx.test.ext:junit:${getVersionString("testExtJunit")}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${getVersionString("espressoVersion")}")
    androidTestImplementation("androidx.test.espresso:espresso-intents:${getVersionString("espressoVersion")}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test:$composeVersion")
    androidTestImplementation("io.mockk:mockk-android:$mockkVersion")
    androidTestImplementation("androidx.test:core:$testCoreVersion")
    androidTestImplementation("androidx.test:rules:$testCoreVersion")
    androidTestImplementation("androidx.test:runner:$testCoreVersion")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}