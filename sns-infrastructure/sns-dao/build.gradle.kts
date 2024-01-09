import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation (project(":sns-domain"))
    implementation (project(":sns-application"))

    implementation ("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly ("com.mysql:mysql-connector-j")
}
