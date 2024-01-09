import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10" apply false
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = "com.sns"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring") //all-open

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")

        //kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation ("org.jeasy:easy-random-core:5.0.0")
        testImplementation("io.kotest:kotest-runner-junit5:5.3.2")
        testImplementation("io.kotest:kotest-assertions-core:5.3.2")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }

        dependencies {
            dependency("net.logstash.logback:logstash-logback-encoder:6.6")
        }
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}
