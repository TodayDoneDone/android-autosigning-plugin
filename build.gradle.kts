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
    `java-gradle-plugin`
    id("com.vanniktech.maven.publish") version "0.22.0"
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()
}
