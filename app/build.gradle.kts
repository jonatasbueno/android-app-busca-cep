// Class to read the local.properties file
import java.util.Properties

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
}

val properties = Properties()
val localPropertiesFile = rootProject.file("local.properties")

if (localPropertiesFile.exists()) {
  properties.load(localPropertiesFile.inputStream())
}

android {
  namespace = "com.example.services"
  compileSdk = 36

  // habilita o uso do BuildConfig
  buildFeatures {
    buildConfig = true
  }

  defaultConfig {
    applicationId = "com.example.services"
    minSdk = 24
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    // Add the API_TOKEN build config field
    buildConfigField(
      "String",
      "API_TOKEN",
      "\"${properties.getProperty("API_TOKEN") ?: ""}\""
    )
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
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.constraintlayout)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)

  /*
  * Libs adicionadas por mim
  *
  * Aqui a string referente a lib retrofit fica armazenada no arquivo "libs.versions.toml"
  * */

  // http request
  implementation(libs.retrofit)
  // conversor gson para retrofit
  implementation(libs.converter.gson)
  implementation(libs.gson)

}