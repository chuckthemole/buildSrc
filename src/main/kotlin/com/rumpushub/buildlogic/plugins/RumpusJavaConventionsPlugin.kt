package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.*

/**
 * Applies Java conventions across Rumpus projects.
 * Sets Java version, repositories, and compiler options.
 */
class RumpusJavaConventionsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Apply Java library plugin
        project.plugins.apply("java-library")

        // Set Java version compatibility
        project.extensions.configure<org.gradle.api.plugins.JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        // Configure repositories
        project.repositories {
            mavenCentral()
        }

        // Configure Java compiler options
        project.tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            options.compilerArgs.addAll(listOf("-Xlint:unchecked", "-Xlint:deprecation"))
        }
    }
}
