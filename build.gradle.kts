plugins {
    java
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "edu.uniupo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.postgresql:postgresql")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    implementation("ch.qos.logback:logback-core")
    implementation("org.slf4j:slf4j-api")
    /*implementation("org.springframework.boot:spring-boot-starter-security")*/
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("ch.qos.logback:logback-classic")
    testImplementation("ch.qos.logback:logback-classic")
    testImplementation("org.assertj:assertj-core")
    testImplementation("com.h2database:h2")
    /*testImplementation("org.springframework.security:spring-security-test")*/
}

tasks.withType<Test> {
    useJUnitPlatform()
}
