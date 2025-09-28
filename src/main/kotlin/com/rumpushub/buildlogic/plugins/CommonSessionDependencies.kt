package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Adds dependencies for Spring Session.
 *
 * This plugin includes core and JDBC session support,
 * so any module requiring Spring Session can apply it
 * to automatically get the required dependencies.
 */
class CommonSessionDependencies : Plugin<Project> {
    override fun apply(project: Project) {
        // --------------------------
        // Spring Session dependencies
        // --------------------------
        project.dependencies.add(
            "implementation",
            "org.springframework.session:spring-session-core:3.0.0"
        )
        project.dependencies.add(
            "implementation",
            "org.springframework.session:spring-session-jdbc:3.0.0"
        )
    }
}
