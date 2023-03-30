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
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.4")
    implementation("com.mysql:mysql-connector-j:8.0.32")
    implementation("org.postgresql:postgresql:42.5.4")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    implementation("ch.qos.logback:logback-core:1.4.6")
    implementation("org.slf4j:slf4j-api:2.0.5")
    /*implementation("org.springframework.boot:spring-boot-starter-security")*/
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:3.0.4")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.4")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("ch.qos.logback:logback-classic:1.4.6")
    testImplementation("ch.qos.logback:logback-classic:1.4.6")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("com.h2database:h2:2.1.214")
    /*testImplementation("org.springframework.security:spring-security-test")*/
}

tasks.withType<Test> {
    useJUnitPlatform()
}
