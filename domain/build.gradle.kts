plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation("javax.inject", "javax.inject", "1")
    implementation("org.jetbrains.kotlin", "kotlin-reflect", "1.9.0")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.8.0-RC2")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.8.2")
    testImplementation("org.assertj", "assertj-core", "3.22.0")
    testImplementation("org.jetbrains.kotlinx", "kotlinx-coroutines-test", "1.8.0-RC2")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
