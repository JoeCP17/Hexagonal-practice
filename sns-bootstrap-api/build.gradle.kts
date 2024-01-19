import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

apply(plugin = "org.springframework.boot")

dependencies {
    implementation(project(":sns-domain"))
    implementation(project(":sns-application"))
    implementation(project(":sns-infrastructure:sns-data"))

    // spring boot
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")

}
