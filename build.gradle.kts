
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
    linuxX64 {
        /**
         * Required files:
         *  /usr/lib/libtinfo.so.5
         *      arch-linux -> install "ncurses5-compat-libs" from AUR
         */
        binaries.executable()
    }
    macosX64 {
        binaries.executable()
    }
    mingwX64(name = "windowsX64") {
        binaries.executable()
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "6.8.1"
    distributionType = Wrapper.DistributionType.ALL
}