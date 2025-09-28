// --------------------------------------------------------------------------
// buildSrc/build.gradle.kts
// --------------------------------------------------------------------------
// This build file configures the buildSrc project, which contains custom
// Gradle plugins and build logic for the main project. Using Kotlin DSL
// provides type-safety, IDE autocompletion, and better maintainability.
// --------------------------------------------------------------------------

plugins {
    // Groovy support for legacy plugin scripts and Spock testing
    // groovy

    // Gradle plugin development support
    // `groovy-gradle-plugin`

    // Kotlin JVM plugin for writing build logic in Kotlin
    // kotlin("jvm") version "1.9.25"
    `kotlin-dsl`
}

// --------------------------------------------------------------------------
// Repositories
// --------------------------------------------------------------------------
// Where to resolve plugin and library dependencies from.
repositories {
    mavenCentral()        // Standard Maven repository
    // gradlePluginPortal()  // Required for Gradle plugins
}

// --------------------------------------------------------------------------
// Dependencies
// --------------------------------------------------------------------------
// Core dependencies needed for plugin compilation and testing.
dependencies {
    implementation(kotlin("gradle-plugin"))

    // Gradle API allows writing custom plugins
    // implementation(gradleApi())

    // Local Groovy runtime for Groovy scripts
    // implementation(localGroovy())

    // Kotlin standard library for JVM
    // implementation(kotlin("stdlib-jdk8"))

    // Testing framework for Groovy (Spock 2.x supports JUnit Platform)
    // testImplementation("org.spockframework:spock-core:2.3-groovy-3.0")
    // Uncomment if needed for full Groovy runtime tests
    // testImplementation("org.codehaus.groovy:groovy-all:3.0.9")
}

// --------------------------------------------------------------------------
// Test Configuration
// --------------------------------------------------------------------------
// Configures test logging and framework.
// tasks.test {
//     // Use JUnit Platform to support Spock 2.x
//     useJUnitPlatform()

//     // Ignore old Groovy test files
//     // Example: all files ending with *GroovyTest.groovy
//     exclude("**/*.groovy")

//     // Log test results to the console
//     testLogging {
//         events("passed", "skipped", "failed")
//         exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//         showStandardStreams = true
//     }
// }

// --------------------------------------------------------------------------
// Notes
// --------------------------------------------------------------------------
// 1. Keep Kotlin and Groovy plugin versions in sync with project requirements.
// 2. Gradle API and localGroovy() are mandatory for custom plugin compilation.
// 3. All test dependencies are isolated to the buildSrc project.
// 4. Avoid adding project-specific dependencies here; this is strictly for
//    plugin/build logic.
// 5. Using Kotlin DSL improves type safety and allows IDE autocompletion.
// --------------------------------------------------------------------------
