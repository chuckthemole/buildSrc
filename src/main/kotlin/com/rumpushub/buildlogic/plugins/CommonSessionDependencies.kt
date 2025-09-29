package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * CommonSessionDependencies
 *
 * Adds dependencies for Spring Session.
 * Supports core and JDBC session modules.
 *
 * Features:
 * - Centralized version management via version catalog or explicit assignment.
 * - Type-safe Kotlin DSL configuration through a Gradle extension.
 * - Clear error messages if required versions/dependencies are not provided.
 *
 * Example usage in build.gradle.kts:
 * ```
 * apply<CommonSessionDependencies>()
 *
 * sessionDeps {
 *     core = rumpusLibs.springSessionCore
 *     jdbc = rumpusLibs.springSessionJdbc
 * }
 * ```
 */
class CommonSessionDependencies : Plugin<Project> {

    open class SessionExtension {
        var core: Any? = null
        var jdbc: Any? = null
    }

    override fun apply(project: Project) {
        val extension = project.extensions.create("sessionDeps", SessionExtension::class.java)

        project.afterEvaluate {
            val coreDep = extension.core
                ?: throw IllegalArgumentException("CommonSessionDependencies requires 'core' to be set (e.g., from version catalog).")
            val jdbcDep = extension.jdbc
                ?: throw IllegalArgumentException("CommonSessionDependencies requires 'jdbc' to be set (e.g., from version catalog).")

            project.dependencies.add("implementation", coreDep)
            project.dependencies.add("implementation", jdbcDep)

            project.logger.lifecycle("CommonSessionDependencies applied: $coreDep, $jdbcDep")
        }
    }
}
