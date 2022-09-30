import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

group = "io.github.durun.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("multiplatform") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    commonMainImplementation(kotlin("stdlib-common"))
}

val os = org.gradle.internal.os.OperatingSystem.current()
kotlin {
    when {
        os.isWindows -> mingwX64("windowsX64")
        os.isMacOsX -> macosX64()
        os.isLinux -> linuxX64()
    }

    targets.withType<KotlinNativeTarget>().all {
        sourceSets {
            getByName("${targetName}Main").apply {
                kotlin.srcDir("src/nativeMain/kotlin")
            }
            getByName("${targetName}Test").apply {
                kotlin.srcDir("src/nativeTest/kotlin")
                dependencies {
                    implementation(kotlin("test-common"))
                }
            }
        }
        binaries {
            executable()
        }
    }
}