// buildSrc/src/main/kotlin/com/rumpushub/buildlogic/plugins/DatabaseDependenciesPlugin.kt
package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Adds database-related dependencies to a project.
 * Includes Spring Boot JDBC, JPA, MySQL, Redis, and jOOQ.
 */
class CommonDBDependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // --------------------------
        // Spring Boot dependencies
        // --------------------------
        project.dependencies.add("implementation", "org.springframework.boot:spring-boot-starter-jdbc:3.0.1")
        project.dependencies.add("implementation", "org.springframework.boot:spring-boot-starter-data-jpa:3.3.3")
        project.dependencies.add("implementation", "mysql:mysql-connector-java:8.0.31")

        // --------------------------
        // Spring Data
        // --------------------------
        project.dependencies.add("implementation", "org.springframework.data:spring-data-bom:2022.0.1")
        project.dependencies.add("implementation", "org.springframework.data:spring-data-commons")

        // --------------------------
        // Redis
        // --------------------------
        project.dependencies.add("implementation", "org.springframework.data:spring-data-redis:3.2.0")
        project.dependencies.add("implementation", "redis.clients:jedis:5.1.2")

        // --------------------------
        // SQL / jOOQ
        // --------------------------
        project.dependencies.add("implementation", "org.jooq:jooq:3.15.1")
    }
}
