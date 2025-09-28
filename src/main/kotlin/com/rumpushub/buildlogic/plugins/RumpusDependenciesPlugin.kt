package com.rumpushub.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Plugin to centralize dependencies for Rumpus modules.
 * 
 * TODO: Make these module-specific; not every module needs all of these.
 */
class RumpusDependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.dependencies {
            // Spring Boot
            "implementation"("org.springframework.boot:spring-boot-starter:3.0.1")
            "implementation"("org.springframework.boot:spring-boot-starter-web:3.0.1") // Enables Spring MVC

            // DB dependencies (commented out for now)
            // "implementation"("org.springframework.data:spring-data-bom:2022.0.0")
            // "implementation"("org.springframework.boot:spring-boot-starter-jdbc:3.0.1")
            // "implementation"("mysql:mysql-connector-java:8.0.31")
            // "testImplementation"("com.h2database:h2:2.1.214")
            // "runtimeOnly"("com.h2database:h2")

            // Spring Data JPA (bootstrapping was messing up run; keeping for future)
            "implementation"("org.springframework.boot:spring-boot-starter-data-jpa")

            // Reactive Streams and WebFlux
            "implementation"("org.reactivestreams:reactive-streams:1.0.4")
            // "implementation"("io.projectreactor:reactor-core:3.5.3")
            "implementation"("org.springframework.boot:spring-boot-starter-webflux:3.0.2")
            "implementation"("org.springframework.boot:spring-boot-starter-security:3.0.2")
            // "implementation"("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE")
            "implementation"("org.springframework.boot:spring-boot-starter-websocket:3.0.2")

            // Spring Boot Actuator / Admin
            "implementation"("org.springframework.boot:spring-boot-starter-actuator")
            "implementation"("de.codecentric:spring-boot-admin-starter-client:3.2.1")
            "implementation"("de.codecentric:spring-boot-admin-starter-server:3.2.1")

            // Dev Tools
            "implementation"("org.springframework.boot:spring-boot-devtools:3.0.1")

            // Apache Commons (used for URL validation)
            "implementation"("commons-validator:commons-validator:1.7")

            // Web / frontend
            "implementation"("org.webjars:bootstrap:5.2.3")
            "implementation"("net.sourceforge.htmlunit:htmlunit:2.70.0")

            // Testing (commented out)
            // "testImplementation"("org.springframework.boot:spring-boot-starter-test")
            // "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.8.1")
            // "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.8.1")

            // HTTP client
            "implementation"("com.konghq:unirest-java:3.11.13")

            // Java annotations
            "implementation"("com.google.code.findbugs:jsr305:3.0.2")

            // HTML generation
            "implementation"("com.j2html:j2html:1.6.0")

            // Python
            "implementation"("org.python:jython-standalone:2.7.2")

            // OCR / Tesseract
            "implementation"("net.sourceforge.tess4j:tess4j:5.13.0")

            // OAuth2
            "implementation"("org.springframework.boot:spring-boot-starter-oauth2-client")
            "implementation"("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.5.0") 
            
            // JWT
            "implementation"("io.jsonwebtoken:jjwt-api:0.12.6")
            "runtimeOnly"("io.jsonwebtoken:jjwt-impl:0.12.6")
            "runtimeOnly"("io.jsonwebtoken:jjwt-jackson:0.12.6") // for Jackson parsing

            // Cloud dependencies (commented out)
            // "implementation"("io.awspring.cloud:spring-cloud-aws:3.1.1")
            // "implementation"("io.awspring.cloud:spring-cloud-aws-starter-s3:3.1.1")
        }
    }
}
