plugins {
    id("java")
    id("java-library")
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
}

subprojects {
    pluginManager.apply("java")
    pluginManager.apply("org.springframework.boot")
    pluginManager.apply("io.spring.dependency-management")
}

allprojects {
    group = "edu.uniupo"
    version = "0.0.1-SNAPSHOT"

    java.sourceCompatibility = JavaVersion.VERSION_17

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
        testCompileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
        testAnnotationProcessor {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    repositories {
        mavenCentral()
        mavenLocal()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("ch.qos.logback:logback-core")
        implementation("org.slf4j:slf4j-api")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.junit.jupiter:junit-jupiter-engine")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("ch.qos.logback:logback-classic")
        testImplementation("ch.qos.logback:logback-classic")
        testImplementation("org.assertj:assertj-core")
    }

}