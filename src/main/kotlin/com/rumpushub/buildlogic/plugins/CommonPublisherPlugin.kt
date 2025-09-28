package com.rumpushub.buildlogic.plugins

import com.rumpushub.buildlogic.utils.EnvLoader
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.*

/**
 * Configures publishing for a Java library to GitHub Packages using Maven Publish.
 * Loads environment variables from a `.env` file and sets credentials and metadata.
 */
class CommonPublisherPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // --- Load environment variables from .env ---
        EnvLoader.loadDotEnv(project)
        val env = if (project.hasProperty("ENV")) project.property("ENV") as String else "DEV"

        if (env == "LIVE") {
            project.afterEvaluate {
                // Configure the publishing block
                extensions.configure<org.gradle.api.publish.PublishingExtension>("publishing") {
                    publications {
                        // Define a Maven publication named "gpr"
                        create("gpr", MavenPublication::class) {
                            // Publish the main Java component
                            // Safe wrapper around `from` with debug info
                            try {
                                from(components["java"])
                            } catch (e: Exception) {
                                println("DEBUG: from() failed in ${project.name}")
                                e.printStackTrace()
                            }

                            // Optional explicit coordinates
                            // groupId = "com.rumpushub.common"
                            // artifactId = "common"
                            // version = "0.1.3"

                            // POM metadata
                            pom {
                                name.set("Rumpus Common Library")
                                description.set("Shared Java utilities and core classes for the Rumpus platform.")
                                url.set("https://github.com/chuckthemole/common")

                                licenses {
                                    license {
                                        name.set("The Apache License, Version 2.0")
                                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                                    }
                                }

                                developers {
                                    developer {
                                        id.set("chuckthemole")
                                        name.set("Charles Thomas")
                                        email.set("chuckthemole@gmail.com")
                                    }
                                }

                                scm {
                                    connection.set("scm:git:git://github.com/chuckthemole/common.git")
                                    developerConnection.set("scm:git:ssh://github.com:chuckthemole/common.git")
                                    url.set("https://github.com/chuckthemole/common")
                                }
                            }
                        }
                    }

                    repositories {
                        maven {
                            name = "GitHubPackages"
                            url = uri("https://maven.pkg.github.com/chuckthemole/common")
                            // url = uri("$rootDir/TestRepo")

                            credentials {
                                username = project.findProperty("GPR_USER")?.toString()
                                    ?: System.getenv("GPR_USER")
                                password = project.findProperty("GPR_TOKEN")?.toString()
                                    ?: System.getenv("GPR_TOKEN")
                            }
                        }
                    }
                }
            }
        }
    }
}
