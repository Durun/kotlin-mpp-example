
plugins {
    /**
     * Check:
     *  - Is the gradle not "offline-mode" ?
     *  - Is the JVM version in which the gradle runs correct?
     */
    kotlin("multiplatform") version "1.3.61"
}

group = "io.github.durun"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    linuxX64 {
        /**
         * Required files:
         *  /usr/lib/libtinfo.so.5
         *      arch-linux -> install "ncurses5-compat-libs" from AUR
         */
        binaries {
            executable()
        }
    }

    macosX64 {
        binaries {
            executable()
        }
    }

    mingwX64(name = "windowsX64") {
        binaries {
            executable()
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "5.3.1"
    distributionType = Wrapper.DistributionType.ALL
}