package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configures standard test dependencies for Rumpus projects.
 */
class RumpusTest : Plugin<Project> {
    override fun apply(project: Project) {
        project.dependencies {
            add("testImplementation", "org.springframework.boot:spring-boot-starter-test")
            add("testImplementation", "org.mockito:mockito-inline:4.2.0")
            add("testImplementation", "org.junit.jupiter:junit-jupiter-api:5.8.1")
            add("testRuntimeOnly", "org.junit.jupiter:junit-jupiter-engine:5.8.1")
            add("testImplementation", "org.springframework.security:spring-security-test:6.3.3")
        }
    }
}
