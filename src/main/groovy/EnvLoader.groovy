import org.gradle.api.Project

/**
 * EnvLoader is a utility class that loads environment variables from a `.env` file
 * located in the parent directory of the current Gradle project's root directory.
 *
 * This is particularly useful for managing secrets or configuration values during local development
 * without hardcoding them into build files or version control.
 *
 * ### Behavior:
 * - Looks for a `.env` file **one directory above** the project's root.
 * - Parses each non-commented line of the form `KEY=VALUE`.
 * - Trims and adds each key-value pair to `project.ext`, making them accessible throughout the build.
 *
 * ### Usage:
 * Typically called in a `build.gradle` or buildSrc plugin or initialization script:
 *
 * ```groovy
 * EnvLoader.loadDotEnv(project)
 * println project.ext.get("GPR_USER")
 * ```
 *
 * ### Example `.env` file:
 * ```
 * GPR_USER=exampleuser
 * GPR_KEY=exampletoken123
 * # This is a comment
 * ```
 *
 * ### Notes:
 * - Lines without an `=` sign or starting with `#` are ignored.
 * - Existing keys in `project.ext` will be overwritten.
 * - Outputs detailed logging to help debug `.env` loading issues.
 */
class EnvLoader {

    /**
     * Loads environment variables from a `.env` file located in the parent directory of the given project.
     *
     * @param project The Gradle Project to attach loaded properties to via `project.ext`.
     */
    static void loadDotEnv(Project project) {
        println "EnvLoader: Starting to load .env file"
        def parentDir = project.rootDir.parentFile
        println "EnvLoader: project.rootDir = ${project.rootDir}"
        println "EnvLoader: looking for .env in parent directory = ${parentDir}"

        def envFile = new File(parentDir, ".env")
        if (envFile.exists()) {
            println "EnvLoader: Found .env file at ${envFile.absolutePath}"
            envFile.eachLine { line ->
                println "EnvLoader: Reading line -> '${line}'"
                if (!line.trim().startsWith("#") && line.contains("=")) {
                    def (key, value) = line.split("=", 2)
                    key = key.trim()
                    value = value.trim()
                    println "EnvLoader: Setting project.ext property: ${key} = ${value}"
                    project.ext.set(key, value)
                } else {
                    println "EnvLoader: Skipping line (comment or no '='): '${line}'"
                }
            }
        } else {
            println "EnvLoader: .env file does NOT exist at ${envFile.absolutePath}"
        }

        println "EnvLoader: Done loading .env"
        println "EnvLoader: project.ext keys after load: ${project.ext.properties.keySet()}"
    }
}
