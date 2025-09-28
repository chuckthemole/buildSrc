package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

/**
 * Configures testing for Rumpus projects.
 */
class RumpusTestConventions : Plugin<Project> {
    override fun apply(project: Project) {
        // Add JUnit 4 dependency
        project.dependencies {
            add("testImplementation", "junit:junit:4.13")
        }

        // Configure the "test" task to use JUnit Platform
        project.tasks.named("test", Test::class.java) {
            useJUnitPlatform()
        }

        // Configure logging for all Test tasks
        project.tasks.withType<Test> {
            testLogging {
                exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                events("started", "skipped", "passed", "failed")
                showStandardStreams = true
            }
        }
    }
}
