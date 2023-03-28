dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.postgresql:postgresql")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    /*implementation("org.springframework.boot:spring-boot-starter-security")*/
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.h2database:h2")
    /*testImplementation("org.springframework.security:spring-security-test")*/
}