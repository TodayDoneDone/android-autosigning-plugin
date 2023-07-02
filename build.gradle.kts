/*
 * Developed by 2022 Ji Sungbin
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/android-autosigning-plugin/blob/main/LICENSE
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    `kotlin-dsl`
    // `maven-publish`
    `java-gradle-plugin`
    id("com.vanniktech.maven.publish") version "0.25.3"
}

// group = "land.sungbin.android.autosigning"
// version = "1.0.4"

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("autoSigningPlugin") {
            id = "land.sungbin.android.autosigning.plugin"
            implementationClass = "AutoSigningPlugin"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    implementation("com.android.tools.build:gradle:8.0.0-alpha08")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()
}
