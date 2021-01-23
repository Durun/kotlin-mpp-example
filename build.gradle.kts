
plugins {
    /**
     * Check:
     *  - Is the gradle not "offline-mode" ?
     *  - Is the JVM version in which the gradle runs correct?
     */
    kotlin("multiplatform") version "1.4.21"
}

group = "io.github.durun"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    commonMainImplementation(kotlin("stdlib-common"))
    commonTestImplementation(kotlin("test-common"))
    commonTestImplementation(kotlin("test-annotations-common"))
}

kotlin {
    /**
     * Required files:
     *  /usr/lib/libtinfo.so.5
     *      arch-linux -> install "ncurses5-compat-libs" from AUR
     */
    linuxX64()
    macosX64()
    mingwX64(name = "windowsX64")
}

tasks.withType<Wrapper> {
    gradleVersion = "6.8.1"
    distributionType = Wrapper.DistributionType.ALL
}