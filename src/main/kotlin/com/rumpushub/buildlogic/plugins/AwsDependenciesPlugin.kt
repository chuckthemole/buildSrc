package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Adds AWS Spring Cloud dependencies to a project.
 * Can be applied in any module that needs AWS S3 integration.
 */
class AwsDependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.dependencies.add("implementation", "io.awspring.cloud:spring-cloud-aws:3.1.1")
        project.dependencies.add("implementation", "io.awspring.cloud:spring-cloud-aws-starter-s3:3.1.1")
    }
}

